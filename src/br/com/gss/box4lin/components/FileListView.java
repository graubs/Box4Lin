/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.components;

import br.com.gss.box4lin.constants.FileListFields;
import br.com.gss.box4lin.controllers.BoxObjectController;
import br.com.gss.box4lin.factories.BoxUserSessionFactory;
import br.com.gss.box4lin.utils.BoxUtil;
import br.com.gss.box4lin.views.BoxFrameMain;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFileInfoResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxAbstractFile;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFile;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Date;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Glauber
 */
public class FileListView extends JTable implements KeyListener, MouseListener {

    public static final int DEFAULT_ROW_HEIGHT = 40;
    public static final int BOX_FILE_ATTRIB_QTY = 7;
    public static final int NO_ROW_SELECTED = -1;
    private String currentNodeID;
    private String previousNodeID;
    private Stack<String> previousNodes;

    public FileListView() {
        setRowHeight(DEFAULT_ROW_HEIGHT);
        setRowSelectionAllowed(true);
        setShowHorizontalLines(true);
        setShowVerticalLines(false);
        setDefaultModel();
        setAutoCreateRowSorter(true);
        addKeyListener(this);
        addMouseListener(this);
        previousNodes = new Stack<>();
    }

    private void setDefaultModel() {
        DefaultTableModel model = new DefaultTableModel(getFieldNames(), 10);
        setModel(model);
    }

    public void fillTable(DefaultMutableTreeNode treeNode) {

        if (null != treeNode) {
            getTableModel().setRowCount(0);

            //previousNodeID = currentNodeID;
            currentNodeID = ((BoxAbstractFile) treeNode.getUserObject()).getId();
            String prevNode = previousNodes.isEmpty() ? "" : previousNodes.peek();
            if (!prevNode.equals(currentNodeID)) {
                previousNodes.push(currentNodeID);
            }

            String[] fields = getFieldNames();

            for (int i = 0; i < fields.length; i++) {
                getTableModel().addColumn(fields[i]);
            }

            for (int i = 0; i < treeNode.getChildCount(); i++) {
                BoxAbstractFile file = (BoxAbstractFile) ((DefaultMutableTreeNode) treeNode.getChildAt(i)).getUserObject();
                getTableModel().getColumnCount();
                getTableModel().addRow(getFileFields(file));
            }
        }
    }

    private Object[] getFileFields(BoxAbstractFile file) {
        //TODO: Change implementation to works with generics
        Object[] result = new Object[BOX_FILE_ATTRIB_QTY];

        result[0] = file.getId();
        result[1] = file.getName();
        result[2] = BoxUtil.getRightMeasuring(file.getSize());
        //TODO Date convert from long type is going wrong
        result[3] = new Date(file.getCreated());
        result[4] = new Date(file.getUpdated());
        result[5] = file.getTags().isEmpty() ? "" : file.getTags();
        result[6] = file.getKeyword();

        return result;
    }

    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) super.getModel();
    }

    private String[] getFieldNames() {
        String[] result = new String[FileListFields.values().length];

        int i = 0;

        for (FileListFields f : FileListFields.values()) {
            result[i] = f.getValue();
            i++;
        }
        return result;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public boolean isAnyRowSelected() {
        return getSelectedRow() == NO_ROW_SELECTED ? false : true;
    }

    private int setPreviousSelectedRow() {
        //return getSelectedRow() == 0 ? getRowCount() - 1 : getSelectedRow() - 1;
        if (getSelectedRow() != NO_ROW_SELECTED) {
            setRowSelectionInterval(
                    getSelectedRow() == 0 ? getRowCount() - 1 : getSelectedRow() - 1,
                    getSelectedRow() == 0 ? getRowCount() - 1 : getSelectedRow() - 1);
        }

        return getSelectedRow();
    }

    private void processSelectEvent(Object o) {
        if (o instanceof FileListView) {
            
            FileListView view = (FileListView) o;
            int row = view.getSelectedRow();
            
            if(row != NO_ROW_SELECTED){
                String targetID = view.getValueAt(row, FileListFields.FILE_ID.getId()).toString();
            GetFileInfoResponse response = null;

            try {
                String authToken = BoxUserSessionFactory.getInstance().getUserSession().getAuthToken();

                response = BoxObjectController.getBoxObjectController().getFileInfo(authToken, targetID);
                BoxFile file = response.getFile();
                if (null == file) { //Is Folder, open it
                    getFrameMain().showBoxResource(
                            getValueAt(
                            getSelectedRow(),
                            FileListFields.FILE_ID.getId()).toString());
                } else { //Is File, download it
                    getFrameMain().getFile();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileListView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BoxException ex) {
                Logger.getLogger(FileListView.class.getName()).log(Level.SEVERE, null, ex);
            }
            }

        }
    }

    public BoxFrameMain getFrameMain() throws NullPointerException {
        Container parent = this;
        boolean found = false;


        while (!found) {
            parent = parent.getParent();
            if (parent instanceof BoxFrameMain) {
                found = true;
            }
        }

        return (BoxFrameMain) parent;
    }

    public void processBackEvent(Object o) {
        if (o instanceof FileListView) {
            previousNodes.pop();
            currentNodeID = previousNodes.isEmpty() ? "" : previousNodes.peek();
            getFrameMain().showBoxResource(getCurrentNodeID());
        }
    }

    public String getCurrentNodeID() {
        return currentNodeID;
    }

    public String getPreviousNodeID() {
        return previousNodeID;
    }

    //Keyboard events
    @Override
    public void keyTyped(KeyEvent e) {
        //Do nothing        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            setPreviousSelectedRow();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            processSelectEvent(e.getSource());
        } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            processBackEvent(e.getSource());
        }
    }

    //Mouse events
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            processSelectEvent(e.getSource());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Do nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //Do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //Do nothing
    }
}
