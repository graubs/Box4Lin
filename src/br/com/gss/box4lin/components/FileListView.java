/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.components;

import br.com.gss.box4lin.constants.FileListFields;
import br.com.gss.box4lin.controllers.BoxObjectController;
import br.com.gss.box4lin.utils.BoxUtil;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFileInfoResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxAbstractFile;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFile;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Date;
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

    public FileListView() {
        setRowHeight(DEFAULT_ROW_HEIGHT);
        setRowSelectionAllowed(true);
        setShowHorizontalLines(true);
        setShowVerticalLines(false);
        setDefaultModel();
        setAutoCreateRowSorter(true);
        addKeyListener(this);
        addMouseListener(this);
    }

    private void setDefaultModel() {
        DefaultTableModel model = new DefaultTableModel(getFieldNames(), 10);
        setModel(model);
    }

    public void fillTable(DefaultMutableTreeNode treeNode) {

        if (null != treeNode) {
            getTableModel().setRowCount(0);

            currentNodeID = ((BoxAbstractFile) treeNode.getUserObject()).getId();

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

    private int getPreviousSelectedRow() {
        return getSelectedRow() == 0 ? getRowCount() - 1 : getSelectedRow() - 1;
    }

    private void processSelectionEvent(Object o) {
        if (o instanceof FileListView) {
            FileListView view = (FileListView) o;
            String targetID = view.getValueAt(view.getPreviousSelectedRow(), FileListFields.FILE_ID.getId()).toString();
            GetFileInfoResponse response = null;
            try {
                response = BoxObjectController.getBoxObjectController().getFileInfo("itjyi8du2sv8jxa9k6yx7xrob6kks72j", targetID);
            } catch (IOException ex) {
                Logger.getLogger(FileListView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BoxException ex) {
                Logger.getLogger(FileListView.class.getName()).log(Level.SEVERE, null, ex);
            }
            BoxFile file = response.getFile();
            System.out.println(file.getFileName());
        }
    }

    private void processBackEvent(Object o) {
        if (o instanceof FileListView) {
            //TODO Implement process event listener
        }
    }

    public String getCurrentNodeID() {
        return currentNodeID;
    }

    //Keyboard events
    @Override
    public void keyTyped(KeyEvent e) {
        //Do nothing        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Do nothing        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            processSelectionEvent(e.getSource());
        } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            processBackEvent(e.getSource());
        }
    }

    //Mouse events
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            processSelectionEvent(e.getSource());
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
