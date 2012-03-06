/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box;

import java.io.IOException;

import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddCommentRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddCommentResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToMyBoxRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToMyBoxResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToTagRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddToTagResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CopyRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CopyResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CreateFolderRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CreateFolderResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DeleteCommentRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DeleteCommentResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DeleteRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DeleteResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DownloadRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DownloadResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.ExportTagsRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.ExportTagsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountInfoRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountInfoResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountTreeRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountTreeResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAuthTokenRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAuthTokenResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetCommentsRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetCommentsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFileInfoRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFileInfoResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFriendsRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetFriendsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetUpdatesRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetUpdatesResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.LogoutRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.LogoutResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.MoveRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.MoveResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PrivateShareRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PrivateShareResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicShareRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicShareResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicUnshareRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.PublicUnshareResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RegisterNewUserRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RegisterNewUserResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RenameRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RenameResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RequestFriendsRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.RequestFriendsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.SearchRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.SearchResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.SetDescriptionRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.SetDescriptionResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.UploadRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.UploadResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.VerifyRegistrationEmailRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.VerifyRegistrationEmailResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * box open api, for detail usage and parameters/responses, please visit box
 * open api official site.
 * 
 * @author Jimmy
 * 
 */
public interface BoxExternalAPI {

    // ////////////////// Authentication

    /**
     * This method is used in the authentication process. The ticket obtained
     * from this method is used to generate an authentication page for the user
     * to login.
     * 
     * @param getTicketRequest
     *            request object
     * @return getTicketResponse response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    GetTicketResponse getTicket(GetTicketRequest getTicketRequest)
            throws IOException, BoxException;

    /**
     * This method is used in the authorization process. You should call this
     * method after the user has authorized oneself on the Box.net partner
     * authentication page. Pass the ticket that you get when calling the
     * get_ticket method.
     * 
     * @param getAuthTokenRequest
     *            request object
     * @return getAuthTokenResponse response object
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    GetAuthTokenResponse getAuthToken(GetAuthTokenRequest getAuthTokenRequest)
            throws IOException, BoxException;

    /**
     * This method is used to logout a user.
     * 
     * @param logoutRequest
     *            request object
     * @return LogoutResponse object
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    LogoutResponse logout(LogoutRequest logoutRequest) throws IOException,
            BoxException;

    /**
     * This method is used to register a user.
     * 
     * @param registerNewUserRequest
     *            request object
     * @return response object
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    RegisterNewUserResponse registerNewUser(
            RegisterNewUserRequest registerNewUserRequest) throws IOException,
            BoxException;

    /**
     * This method is used to verify whether a user email is available, or
     * already in use.
     * 
     * @param verifyRegistrationEmailRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    VerifyRegistrationEmailResponse verifyRegistrationEmail(
            VerifyRegistrationEmailRequest verifyRegistrationEmailRequest)
            throws IOException, BoxException;

    /**
     * This method is used to get the user's account information.
     * 
     * @param getAccountInfoRequest
     *            request object
     * @return response object
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    GetAccountInfoResponse getAccountInfo(
            GetAccountInfoRequest getAccountInfoRequest) throws IOException,
            BoxException;

    // ////////////////// File & Folder Operations

    /**
     * This method is used to get a tree representing all of the user's files
     * and folders.
     * 
     * @param getAccountTreeRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    GetAccountTreeResponse getAccountTree(
            GetAccountTreeRequest getAccountTreeRequest) throws IOException,
            BoxException;

    /**
     * This method creates a new folder in a user's account.
     * 
     * @param createFolderRequest
     *            request object
     * @return response object
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    CreateFolderResponse createFolder(CreateFolderRequest createFolderRequest)
            throws IOException, BoxException;

    /**
     * This method moves a file or folder into another folder.
     * 
     * @param moveRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    MoveResponse move(MoveRequest moveRequest) throws IOException, BoxException;

    /**
     * This method copies a file into another folder.
     * 
     * @param copyRequest
     *            request object
     * @return respone object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    CopyResponse copy(CopyRequest copyRequest) throws IOException, BoxException;

    /**
     * This method renames a file or folder.
     * 
     * @param renameRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    RenameResponse rename(RenameRequest renameRequest) throws IOException,
            BoxException;

    /**
     * This method deletes a file or folder.
     * 
     * @param deleteRequest
     *            request object
     * @return response object
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    DeleteResponse delete(DeleteRequest deleteRequest) throws IOException,
            BoxException;

    /**
     * This method retrieves the details for a specified file.
     * 
     * @param getFileInfoRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    GetFileInfoResponse getFileInfo(GetFileInfoRequest getFileInfoRequest)
            throws IOException, BoxException;

    /**
     * This method sets the description for a file or folder.
     * 
     * @param setDescriptionRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    SetDescriptionResponse setDescription(
            SetDescriptionRequest setDescriptionRequest) throws IOException,
            BoxException;

    // ////////////////// Sharing

    /**
     * This method makes a file or folder shareable, and may initiate sharing
     * through Box.net email notifications.
     * 
     * @param publicShareRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    PublicShareResponse publicShare(PublicShareRequest publicShareRequest)
            throws IOException, BoxException;

    /**
     * This method unshares a shared file or folder.
     * 
     * @param publicUnshareRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    PublicUnshareResponse publicUnshare(
            PublicUnshareRequest publicUnshareRequest) throws IOException,
            BoxException;

    /**
     * This method privately shares a file or folder with another user(s).
     * 
     * @param privateShareRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    PrivateShareResponse privateShare(PrivateShareRequest privateShareRequest)
            throws IOException, BoxException;

    /**
     * This method requests new friends to be added to the user's network.
     * 
     * @param requestFriendsRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    RequestFriendsResponse requestFriends(
            RequestFriendsRequest requestFriendsRequest) throws IOException,
            BoxException;

    /**
     * This method is used to retrieve a list of the user's friends.
     * 
     * @param getFriendsRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    GetFriendsResponse getFriends(GetFriendsRequest getFriendsRequest)
            throws IOException, BoxException;

    /**
     * This method copies a file that publicly shared by another individual and
     * into a user's a designated folder in the user's Box.
     * 
     * @param addToMyBoxRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    AddToMyBoxResponse addToMyBox(AddToMyBoxRequest addToMyBoxRequest)
            throws IOException, BoxException;

    // ////////////////// Tagging

    /**
     * This method applies a tag or tags to a designated file or folder.
     * 
     * @param addToTagRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    AddToTagResponse addToTag(AddToTagRequest addToTagRequest)
            throws IOException, BoxException;

    /**
     * This method returns all the tags in a user's account. Note that, if you
     * want to find the tags associated with a particular file or folder,
     * get_account_tree can be used.
     * 
     * @param exportTagsRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    ExportTagsResponse exportTags(ExportTagsRequest exportTagsRequest)
            throws IOException, BoxException;

    // ////////////////// Commenting

    /**
     * This method is used to retrieve the comments on an item.
     * 
     * @param getCommentsRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    GetCommentsResponse getComments(GetCommentsRequest getCommentsRequest)
            throws IOException, BoxException;

    /**
     * This method is used to add a comment to an item.
     * 
     * @param addCommentRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    AddCommentResponse addComment(AddCommentRequest addCommentRequest)
            throws IOException, BoxException;

    /**
     * This method is used to delete a comment.
     * 
     * @param deleteCommentRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    DeleteCommentResponse deleteComment(
            DeleteCommentRequest deleteCommentRequest) throws IOException,
            BoxException;

    // ////////////////// Miscelaneous

    /**
     * This method makes a file or folder shareable, and may initiate sharing
     * through Box.net email notifications.
     * 
     * @param searchRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    SearchResponse search(SearchRequest searchRequest) throws IOException,
            BoxException;

    /**
     * This method returns the content of a user's Updates tab.
     * 
     * @param getUpdatesRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    GetUpdatesResponse getUpdates(GetUpdatesRequest getUpdatesRequest)
            throws IOException, BoxException;

    // //////// Download & Upload

    /**
     * download a file.
     * 
     * @param downloadRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    DownloadResponse download(DownloadRequest downloadRequest)
            throws IOException, BoxException;

    /**
     * upload files.
     * 
     * @param uploadRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    UploadResponse upload(UploadRequest uploadRequest) throws IOException,
            BoxException;

}
