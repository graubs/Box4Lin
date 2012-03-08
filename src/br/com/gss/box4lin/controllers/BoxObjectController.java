/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.controllers;

import br.com.gss.box4lin.constants.ApplicationConstants;
import br.com.gss.box4lin.factories.BoxExternalFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxRequestFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.*;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFile;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFolder;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.UploadResult;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author glauber
 */
public class BoxObjectController {

    private static BoxObjectController boxObjectController;

    private BoxObjectController() {
    }

    public static BoxObjectController getBoxObjectController() {
        if (null == boxObjectController) {
            boxObjectController = new BoxObjectController();
        }
        return boxObjectController;
    }

    public BoxFolder createFolder(String authToken, String folderName, String parentFolder, boolean share)
            throws IOException, BoxException {
        CreateFolderRequest request = BoxRequestFactory.createCreateFolderRequest(
                ApplicationConstants.API_KEY, authToken, parentFolder, folderName, share);
        CreateFolderResponse response = BoxExternalFactory.getBoxExternalAPI().createFolder(request);
        return response.getFolder();
    }

    public BoxFile uploadFile(String authToken, String parentFolder, File file)
            throws IOException, BoxException, NullPointerException {
        
        Map fileMap = new HashMap();
        fileMap.put(file.getName(), file);
        
        UploadRequest request = BoxRequestFactory.createUploadRequest(authToken, true, parentFolder, fileMap);

        UploadResponse response = BoxExternalFactory.getBoxExternalAPI().upload(request);

        UploadResult result = (UploadResult) response.getUploadResultList().get(ApplicationConstants.LIST_UNIQUE_ITEM);

        return result.getFile();
    }

    public PublicShareResponse shareItem(String authToken, String targetType, String targetID, String message) 
            throws IOException, BoxException, NullPointerException {

        PublicShareRequest request = BoxRequestFactory.createPublicShareRequest(
                ApplicationConstants.API_KEY, authToken, targetType, targetID, targetID, message, null);

        return BoxExternalFactory.getBoxExternalAPI().publicShare(request);
    }

    public PublicUnshareResponse unshareItem(String authToken, String targetType, String targetID) 
            throws IOException, BoxException, NullPointerException {

        PublicUnshareRequest request = BoxRequestFactory.createPublicUnshareRequest(
                ApplicationConstants.API_KEY, authToken, targetType, targetID);

        return BoxExternalFactory.getBoxExternalAPI().publicUnshare(request);
    }

    public GetAccountTreeResponse getRemoteTree(String authToken, String folderId, String[] params) 
            throws IOException, BoxException, NullPointerException {

        if(null == params || params.length == 0){
            params = new String [] {ApplicationConstants.PARAM_NO_ZIP};
        }
        
        GetAccountTreeRequest request = BoxRequestFactory.createGetAccountTreeRequest(
                ApplicationConstants.API_KEY, authToken, folderId, params);

        return BoxExternalFactory.getBoxExternalAPI().getAccountTree(request);
    }

    public File downloadFile(String authToken, String path, String fileName, String uploadedFileId) 
            throws IOException, BoxException, NullPointerException {
    
        File file = new File(path, fileName);
                
        DownloadRequest request = BoxRequestFactory.createDownloadRequest(authToken, uploadedFileId, true, file);
        
        return BoxExternalFactory.getBoxExternalAPI().download(request).getOutFile();
    }

    public DeleteResponse deleteFile(String authToken, String targetType, String targetId) 
            throws IOException, BoxException, NullPointerException {
    
        DeleteRequest request = BoxRequestFactory.createDeleteRequest(
                ApplicationConstants.API_KEY, authToken, targetType, targetId);
        
        return BoxExternalFactory.getBoxExternalAPI().delete(request);
    }
    
    public GetFileInfoResponse getFileInfo(String authToken, String fileID) 
            throws IOException, BoxException{
        GetFileInfoRequest request = BoxRequestFactory.createGetFileInfoRequest(
                ApplicationConstants.API_KEY, authToken, fileID);
        return BoxExternalFactory.getBoxExternalAPI().getFileInfo(request);
        
    }
    
}
