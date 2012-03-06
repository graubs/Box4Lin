/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.views;

import br.com.gss.box4lin.constants.ApplicationConstants;
import br.com.gss.box4lin.constants.FileListFields;
import br.com.gss.box4lin.controllers.BoxInfraController;
import br.com.gss.box4lin.controllers.BoxObjectController;
import br.com.gss.box4lin.factories.BoxUserSessionFactory;
import br.com.gss.box4lin.utils.BoxUtil;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DeleteResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFile;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFolder;
import java.io.*;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author glauber
 */
public class MainTest extends javax.swing.JFrame {

    /**
     * Creates new form MainTest
     */
    public MainTest(String authToken) {
        setLookAndFeel();
        initComponents();
        
        this.authToken = BoxUserSessionFactory.getInstance().getUserSession().getAuthToken();
        
        if (this.authToken != null && !this.authToken.equals("")) {
            //Always retrieve the root node on startup
            showBoxResource(ApplicationConstants.ROOT_NODE);
        }        
    }

    private void showBoxResource(String node) {
        
        try {
            
            String[] params = {"nozip", "onelevel"};
            remoteTree = BoxObjectController.getBoxObjectController().getRemoteTree(
                    authToken, node, params).getTree();

            fileListMain.fillTable(remoteTree);
            updateStorageInfo();
        } catch (IOException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BoxException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void updateStorageInfo(){
        try {
            Map info = BoxInfraController.getInstance().getStorageInfo(
                    BoxUserSessionFactory.getInstance().getUserSession().getTicket());
            long spaceAmount = (long)info.get(BoxInfraController.KEY_SPACE_AMOUNT);
            long spaceUsed = (long)info.get(BoxInfraController.KEY_SPACE_USED);
            
            double spaceAmountInGB = BoxUtil.bytesToGigaBytes(spaceAmount);
            double spaceUsedInGB = BoxUtil.bytesToGigaBytes(spaceUsed);
            storageInfo.setMinimum(0);
            storageInfo.setMaximum((int)spaceAmountInGB);
            storageInfo.setValue((int)spaceUsedInGB);
            storageInfo.setString("Using " + BoxUtil.getRightMeasuring(spaceUsed) + " of " + BoxUtil.getRightMeasuring(spaceAmount));
        } catch (IOException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BoxException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneView = new javax.swing.JScrollPane();
        fileListMain = new br.com.gss.box4lin.components.FileListView();
        toolBarMain = new javax.swing.JToolBar();
        getFileButton = new javax.swing.JButton();
        sendFileButton = new javax.swing.JButton();
        createFileButton = new javax.swing.JButton();
        deleteFileButton = new javax.swing.JButton();
        createFolderButton = new javax.swing.JButton();
        deleteFolderButton = new javax.swing.JButton();
        refreshBoxButton = new javax.swing.JButton();
        shareItemButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        storageInfo = new javax.swing.JProgressBar();
        tollBarNotification = new javax.swing.JToolBar();
        notificationLabel = new javax.swing.JLabel();
        notificationProgressBar = new javax.swing.JProgressBar();
        menuBarMain = new javax.swing.JMenuBar();
        menuBox = new javax.swing.JMenu();
        itemLogin = new javax.swing.JMenuItem();
        itemLogout = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemExit = new javax.swing.JMenuItem();
        menuFile = new javax.swing.JMenu();
        itemGetFile = new javax.swing.JMenuItem();
        itemSendFile = new javax.swing.JMenuItem();
        itemCreateFile = new javax.swing.JMenuItem();
        itemDeleteFile = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        itemCreateFolder = new javax.swing.JMenuItem();
        itemDeleteFolder = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemRefreshBox = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        itemContent = new javax.swing.JMenuItem();
        itemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Box4Lin");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(1024, 600));

        fileListMain.setAutoCreateColumnsFromModel(false);
        fileListMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPaneView.setViewportView(fileListMain);

        toolBarMain.setFloatable(false);
        toolBarMain.setRollover(true);

        getFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gss/box4lin/images/imp.png"))); // NOI18N
        getFileButton.setText("Get File");
        getFileButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getFileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getFileButton.setFocusable(false);
        getFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getFileButton.setMaximumSize(new java.awt.Dimension(80, 78));
        getFileButton.setMinimumSize(new java.awt.Dimension(80, 78));
        getFileButton.setPreferredSize(new java.awt.Dimension(80, 78));
        getFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getFileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                getFileButtonMouseReleased(evt);
            }
        });
        toolBarMain.add(getFileButton);

        sendFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gss/box4lin/images/exp.png"))); // NOI18N
        sendFileButton.setText("Send File");
        sendFileButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sendFileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendFileButton.setFocusable(false);
        sendFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sendFileButton.setMaximumSize(new java.awt.Dimension(80, 78));
        sendFileButton.setMinimumSize(new java.awt.Dimension(80, 78));
        sendFileButton.setPreferredSize(new java.awt.Dimension(80, 78));
        sendFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sendFileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sendFileButtonMouseReleased(evt);
            }
        });
        toolBarMain.add(sendFileButton);

        createFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gss/box4lin/images/docad.png"))); // NOI18N
        createFileButton.setText("Add File");
        createFileButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        createFileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createFileButton.setFocusable(false);
        createFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createFileButton.setMaximumSize(new java.awt.Dimension(80, 78));
        createFileButton.setMinimumSize(new java.awt.Dimension(80, 78));
        createFileButton.setPreferredSize(new java.awt.Dimension(80, 78));
        createFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        createFileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                createFileButtonMouseReleased(evt);
            }
        });
        toolBarMain.add(createFileButton);

        deleteFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gss/box4lin/images/docre.png"))); // NOI18N
        deleteFileButton.setText("Delete File");
        deleteFileButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deleteFileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteFileButton.setFocusable(false);
        deleteFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteFileButton.setMaximumSize(new java.awt.Dimension(80, 78));
        deleteFileButton.setMinimumSize(new java.awt.Dimension(80, 78));
        deleteFileButton.setPreferredSize(new java.awt.Dimension(80, 78));
        deleteFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteFileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteFileButtonMouseReleased(evt);
            }
        });
        toolBarMain.add(deleteFileButton);

        createFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gss/box4lin/images/folad.png"))); // NOI18N
        createFolderButton.setText("Add Folder");
        createFolderButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        createFolderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createFolderButton.setFocusable(false);
        createFolderButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createFolderButton.setMaximumSize(new java.awt.Dimension(80, 78));
        createFolderButton.setMinimumSize(new java.awt.Dimension(80, 78));
        createFolderButton.setPreferredSize(new java.awt.Dimension(80, 78));
        createFolderButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        createFolderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                createFolderButtonMouseReleased(evt);
            }
        });
        toolBarMain.add(createFolderButton);

        deleteFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gss/box4lin/images/folre.png"))); // NOI18N
        deleteFolderButton.setText("Delete Folder");
        deleteFolderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteFolderButton.setFocusable(false);
        deleteFolderButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteFolderButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteFolderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteFolderButtonMouseReleased(evt);
            }
        });
        toolBarMain.add(deleteFolderButton);

        refreshBoxButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gss/box4lin/images/ref.png"))); // NOI18N
        refreshBoxButton.setText("Refresh");
        refreshBoxButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        refreshBoxButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshBoxButton.setFocusable(false);
        refreshBoxButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshBoxButton.setMaximumSize(new java.awt.Dimension(80, 78));
        refreshBoxButton.setMinimumSize(new java.awt.Dimension(80, 78));
        refreshBoxButton.setPreferredSize(new java.awt.Dimension(80, 78));
        refreshBoxButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        refreshBoxButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                refreshBoxButtonMouseReleased(evt);
            }
        });
        toolBarMain.add(refreshBoxButton);

        shareItemButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gss/box4lin/images/favad.png"))); // NOI18N
        shareItemButton.setText("Share");
        shareItemButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shareItemButton.setEnabled(false);
        shareItemButton.setFocusable(false);
        shareItemButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        shareItemButton.setMaximumSize(new java.awt.Dimension(80, 78));
        shareItemButton.setMinimumSize(new java.awt.Dimension(80, 78));
        shareItemButton.setPreferredSize(new java.awt.Dimension(80, 78));
        shareItemButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBarMain.add(shareItemButton);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gss/box4lin/images/favre.png"))); // NOI18N
        jButton1.setText("Unshare");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setEnabled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(80, 78));
        jButton1.setMinimumSize(new java.awt.Dimension(80, 78));
        jButton1.setPreferredSize(new java.awt.Dimension(80, 78));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBarMain.add(jButton1);

        storageInfo.setMaximumSize(new java.awt.Dimension(200, 20));
        storageInfo.setMinimumSize(new java.awt.Dimension(200, 20));
        storageInfo.setPreferredSize(new java.awt.Dimension(200, 20));
        storageInfo.setStringPainted(true);
        toolBarMain.add(storageInfo);

        tollBarNotification.setFloatable(false);
        tollBarNotification.setRollover(true);

        notificationLabel.setMinimumSize(new java.awt.Dimension(800, 14));
        notificationLabel.setPreferredSize(new java.awt.Dimension(800, 14));
        tollBarNotification.add(notificationLabel);
        tollBarNotification.add(notificationProgressBar);

        menuBox.setText("Box");

        itemLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        itemLogin.setText("Login using another Box Account...");
        menuBox.add(itemLogin);

        itemLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        itemLogout.setText("Logout (Logged as Graubs)");
        menuBox.add(itemLogout);
        menuBox.add(jSeparator3);

        itemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        itemExit.setText("Exit");
        itemExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemExitMouseReleased(evt);
            }
        });
        menuBox.add(itemExit);

        menuBarMain.add(menuBox);

        menuFile.setText("File");

        itemGetFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        itemGetFile.setText("Get File");
        itemGetFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemGetFileMouseReleased(evt);
            }
        });
        menuFile.add(itemGetFile);

        itemSendFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itemSendFile.setText("Send File...");
        itemSendFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemSendFileMouseReleased(evt);
            }
        });
        menuFile.add(itemSendFile);

        itemCreateFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        itemCreateFile.setText("Create File...");
        itemCreateFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemCreateFileMouseReleased(evt);
            }
        });
        menuFile.add(itemCreateFile);

        itemDeleteFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        itemDeleteFile.setText("Delete File");
        itemDeleteFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemDeleteFileMouseReleased(evt);
            }
        });
        menuFile.add(itemDeleteFile);
        menuFile.add(jSeparator2);

        itemCreateFolder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        itemCreateFolder.setText("Create Folder...");
        itemCreateFolder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemCreateFolderMouseReleased(evt);
            }
        });
        menuFile.add(itemCreateFolder);

        itemDeleteFolder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        itemDeleteFolder.setText("Delete Folder");
        itemDeleteFolder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemDeleteFolderMouseReleased(evt);
            }
        });
        menuFile.add(itemDeleteFolder);
        menuFile.add(jSeparator1);

        itemRefreshBox.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        itemRefreshBox.setText("Refresh Box");
        itemRefreshBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                itemRefreshBoxMouseReleased(evt);
            }
        });
        menuFile.add(itemRefreshBox);

        menuBarMain.add(menuFile);

        menuHelp.setText("Help");

        itemContent.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemContent.setText("Content...");
        menuHelp.add(itemContent);

        itemAbout.setText("About...");
        menuHelp.add(itemAbout);

        menuBarMain.add(menuHelp);

        setJMenuBar(menuBarMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBarMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneView, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(tollBarNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBarMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneView, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tollBarNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBoxButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBoxButtonMouseReleased
        showBoxResource(fileListMain.getCurrentNodeID());
    }//GEN-LAST:event_refreshBoxButtonMouseReleased

    private void itemExitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemExitMouseReleased
        if (JOptionPane.showConfirmDialog(this, "Exit " + ApplicationConstants.APPLICATION_NAME + "?", ApplicationConstants.APPLICATION_NAME, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_itemExitMouseReleased

    private void itemGetFileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemGetFileMouseReleased
        getFileButtonMouseReleased(evt);
    }//GEN-LAST:event_itemGetFileMouseReleased

    private void deleteFileButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteFileButtonMouseReleased
        if (fileListMain.isAnyRowSelected()) {
            if (JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this file?", ApplicationConstants.APPLICATION_NAME, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    String targetID = fileListMain.getValueAt(fileListMain.getSelectedRow(), FileListFields.FILE_ID.getId()).toString();
                    DeleteResponse response = BoxObjectController.getBoxObjectController().deleteFile(
                            authToken, ApplicationConstants.TARGET_FILE, targetID);

                    if (response.getStatus().equals(ApplicationConstants.STATUS_E_DELETE_NODE)) {
                        JOptionPane.showMessageDialog(
                                this, "Please select a file to delete.",
                                ApplicationConstants.APPLICATION_NAME, JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                                this, "File deleted succesfully.",
                                ApplicationConstants.APPLICATION_NAME, JOptionPane.INFORMATION_MESSAGE);
                        showBoxResource(fileListMain.getCurrentNodeID());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BoxException ex) {
                    Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(
                    this, "Please select a file to delete.",
                    ApplicationConstants.APPLICATION_NAME, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteFileButtonMouseReleased

    private void getFileButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getFileButtonMouseReleased
        try {
            if (!fileListMain.isAnyRowSelected()) {
                JOptionPane.showMessageDialog(
                        this, "Please select a file to download.",
                        ApplicationConstants.APPLICATION_NAME, JOptionPane.WARNING_MESSAGE);
                return;
            }

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
            fileChooser.setCurrentDirectory(new File(lastFileDownloadPath));
            fileChooser.setSelectedFile(new File(fileListMain.getValueAt(fileListMain.getSelectedRow(),
                    FileListFields.FILE_NAME.getId()).toString()));
            fileChooser.showSaveDialog(this);

            lastFileDownloadPath = fileChooser.getCurrentDirectory().getPath();

            BoxObjectController.getBoxObjectController().downloadFile(
                    authToken, fileChooser.getCurrentDirectory().getPath(),
                    fileChooser.getSelectedFile().getName(), fileListMain.getValueAt(fileListMain.getSelectedRow(),
                    FileListFields.FILE_ID.getId()).toString());

            JOptionPane.showMessageDialog(
                    this, "File downloaded successfully.",
                    ApplicationConstants.APPLICATION_NAME, JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BoxException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_getFileButtonMouseReleased

    private void createFolderButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createFolderButtonMouseReleased
        String folderName = JOptionPane.showInputDialog(this, "Type the folder name:", ApplicationConstants.APPLICATION_NAME, JOptionPane.OK_CANCEL_OPTION);
        if (folderName != null && folderName.length() > 0) {
            try {
                BoxFolder folder = BoxObjectController.getBoxObjectController().createFolder(
                        authToken, folderName, fileListMain.getCurrentNodeID(), false);
                if (folder == null) {
                    JOptionPane.showMessageDialog(this, "There are a folder with this name. Please choose another one.",
                            ApplicationConstants.APPLICATION_NAME, JOptionPane.WARNING_MESSAGE);
                    return;
                }
                showBoxResource(fileListMain.getCurrentNodeID());
            } catch (IOException ex) {
                Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BoxException ex) {
                Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_createFolderButtonMouseReleased

    private void deleteFolderButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteFolderButtonMouseReleased
        if (fileListMain.isAnyRowSelected()) {
            if (JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this folder and it content?", ApplicationConstants.APPLICATION_NAME, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    String targetID = fileListMain.getValueAt(fileListMain.getSelectedRow(), FileListFields.FILE_ID.getId()).toString();
                    DeleteResponse response = BoxObjectController.getBoxObjectController().deleteFile(authToken, ApplicationConstants.TARGET_FOLDER, targetID);

                    if (response.getStatus().equals(ApplicationConstants.STATUS_E_DELETE_NODE)) {
                        JOptionPane.showMessageDialog(
                                this, "Please select a folder to delete.",
                                ApplicationConstants.APPLICATION_NAME, JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                                this, "Folder deleted successfully.",
                                ApplicationConstants.APPLICATION_NAME, JOptionPane.INFORMATION_MESSAGE);
                        showBoxResource(fileListMain.getCurrentNodeID());
                    }
                } catch (IOException ex) {
                    Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BoxException ex) {
                    Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(
                    this, "Please select a folder to delete.",
                    ApplicationConstants.APPLICATION_NAME, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_deleteFolderButtonMouseReleased

    private void sendFileButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendFileButtonMouseReleased
        try {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
            fileChooser.setCurrentDirectory(new File(lastFileUploadPath));
            fileChooser.showOpenDialog(this);

            if (null != fileChooser.getSelectedFile()) {

                lastFileUploadPath = fileChooser.getCurrentDirectory().getPath();

                File file = new File(fileChooser.getCurrentDirectory().getPath(), fileChooser.getSelectedFile().getName());

                BoxFile boxFile = BoxObjectController.getBoxObjectController().uploadFile(
                        authToken, fileListMain.getCurrentNodeID(), file);

                if (null != boxFile.getFileId()) {
                    JOptionPane.showMessageDialog(
                            this, "File uploaded successfully.",
                            ApplicationConstants.APPLICATION_NAME, JOptionPane.INFORMATION_MESSAGE);

                    showBoxResource(fileListMain.getCurrentNodeID());
                } else {
                    JOptionPane.showMessageDialog(
                            this, "Could not upload the file. Please try again.",
                            ApplicationConstants.APPLICATION_NAME, JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BoxException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendFileButtonMouseReleased

    private void createFileButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createFileButtonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_createFileButtonMouseReleased

    private void itemSendFileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemSendFileMouseReleased
        sendFileButtonMouseReleased(evt);
    }//GEN-LAST:event_itemSendFileMouseReleased

    private void itemCreateFileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemCreateFileMouseReleased
        createFileButtonMouseReleased(evt);
    }//GEN-LAST:event_itemCreateFileMouseReleased

    private void itemDeleteFileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemDeleteFileMouseReleased
        deleteFileButtonMouseReleased(evt);
    }//GEN-LAST:event_itemDeleteFileMouseReleased

    private void itemCreateFolderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemCreateFolderMouseReleased
        createFolderButtonMouseReleased(evt);
    }//GEN-LAST:event_itemCreateFolderMouseReleased

    private void itemDeleteFolderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemDeleteFolderMouseReleased
        deleteFolderButtonMouseReleased(evt);
    }//GEN-LAST:event_itemDeleteFolderMouseReleased

    private void itemRefreshBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemRefreshBoxMouseReleased
        refreshBoxButtonMouseReleased(evt);
    }//GEN-LAST:event_itemRefreshBoxMouseReleased

    private void setLookAndFeel() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createFileButton;
    private javax.swing.JButton createFolderButton;
    private javax.swing.JButton deleteFileButton;
    private javax.swing.JButton deleteFolderButton;
    private br.com.gss.box4lin.components.FileListView fileListMain;
    private javax.swing.JButton getFileButton;
    private javax.swing.JMenuItem itemAbout;
    private javax.swing.JMenuItem itemContent;
    private javax.swing.JMenuItem itemCreateFile;
    private javax.swing.JMenuItem itemCreateFolder;
    private javax.swing.JMenuItem itemDeleteFile;
    private javax.swing.JMenuItem itemDeleteFolder;
    private javax.swing.JMenuItem itemExit;
    private javax.swing.JMenuItem itemGetFile;
    private javax.swing.JMenuItem itemLogin;
    private javax.swing.JMenuItem itemLogout;
    private javax.swing.JMenuItem itemRefreshBox;
    private javax.swing.JMenuItem itemSendFile;
    private javax.swing.JButton jButton1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuBar menuBarMain;
    private javax.swing.JMenu menuBox;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JProgressBar notificationProgressBar;
    private javax.swing.JButton refreshBoxButton;
    private javax.swing.JScrollPane scrollPaneView;
    private javax.swing.JButton sendFileButton;
    private javax.swing.JButton shareItemButton;
    private javax.swing.JProgressBar storageInfo;
    private javax.swing.JToolBar tollBarNotification;
    private javax.swing.JToolBar toolBarMain;
    // End of variables declaration//GEN-END:variables
    String authToken;
    DefaultMutableTreeNode remoteTree;
    String lastFileDownloadPath = "";
    String lastFileUploadPath = "";
}