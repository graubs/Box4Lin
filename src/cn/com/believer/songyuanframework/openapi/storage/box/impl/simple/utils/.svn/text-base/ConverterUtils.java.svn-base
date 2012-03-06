/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.utils;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxObjectFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.Box;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxComment;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFile;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFolder;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFriend;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxSubscription;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxTag;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxUpdate;

/**
 * @author Jimmy
 * 
 */
public final class ConverterUtils {

    /**
     * 
     */
    private ConverterUtils() {
    }

    /**
     * convert tags element to tag list.
     * 
     * @param tagsElm
     *            tags element
     * @return object list
     */
    public static List transferTags2List(Element tagsElm) {
        List tagsList = new ArrayList();
        for (int i = 0; i < tagsElm.nodeCount(); i++) {
            Element tagElm = (Element) tagsElm.node(i);
            String id = tagElm.attributeValue("id");
            String name = tagElm.getText();
            BoxTag tag = BoxObjectFactory.createBoxTag();
            tag.setId(id);
            tag.setName(name);
            tagsList.add(tag);
        }
        return tagsList;
    }

    /**
     * 
     * @param folderElm
     *            folder element
     * @return object
     */
    public static BoxFolder toBoxFolder(Element folderElm) {
        BoxFolder boxFolder = BoxObjectFactory.createBoxFolder();
        Element folderIdElm = folderElm.element(BoxConstant.PARAM_NAME_FOLDER_ID);
        Element idElm = folderElm.element(BoxConstant.PARAM_NAME_ID);
        Element folderNameElm = folderElm.element(BoxConstant.PARAM_NAME_FOLDER_NAME);
        Element nameElm = folderElm.element(BoxConstant.PARAM_NAME_NAME);
        Element folderTypeIdElm = folderElm.element(BoxConstant.PARAM_NAME_FOLDER_TYPE_ID);
        Element parentFolderIdElm = folderElm.element(BoxConstant.PARAM_NAME_PARENT_FOLDER_ID);
        Element userIdElm = folderElm.element(BoxConstant.PARAM_NAME_USER_ID);
        Element pathElm = folderElm.element(BoxConstant.PARAM_NAME_PATH);
        Element sharedElm = folderElm.element(BoxConstant.PARAM_NAME_SHARED);
        Element publicNameElm = folderElm.element(BoxConstant.PARAM_NAME_PUBLIC_NAME);
        Element showCommentsElm = folderElm.element(BoxConstant.PARAM_NAME_SHOW_COMMENTS);
        Element passwordElm = folderElm.element(BoxConstant.PARAM_NAME_PASSWORD);
        Element checksumElm = folderElm.element(BoxConstant.PARAM_NAME_CHECKSUM);
        Element hasCollaboratorsElm = folderElm.element(BoxConstant.PARAM_NAME_HAS_COLLABORATORS);

        if (folderIdElm != null) {
            boxFolder.setFolderId(folderIdElm.getText());
        } else if (idElm != null) {
            boxFolder.setFolderId(idElm.getText());
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_FOLDER_ID) != null) {
            boxFolder.setFolderId(folderElm.attributeValue(BoxConstant.PARAM_NAME_FOLDER_ID));
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_ID) != null) {
            boxFolder.setFolderId(folderElm.attributeValue(BoxConstant.PARAM_NAME_ID));
        }
        if (folderNameElm != null) {
            boxFolder.setFolderName(folderNameElm.getText());
        } else if (nameElm != null) {
            boxFolder.setFolderName(nameElm.getText());
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_FOLDER_NAME) != null) {
            boxFolder.setFolderName(folderElm.attributeValue(BoxConstant.PARAM_NAME_FOLDER_NAME));
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_NAME) != null) {
            boxFolder.setFolderName(folderElm.attributeValue(BoxConstant.PARAM_NAME_NAME));
        }
        if (folderTypeIdElm != null) {
            boxFolder.setFolderTypeId(folderTypeIdElm.getText());
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_FOLDER_TYPE_ID) != null) {
            boxFolder.setFolderTypeId(folderElm.attributeValue(BoxConstant.PARAM_NAME_FOLDER_TYPE_ID));
        }
        if (parentFolderIdElm != null) {
            boxFolder.setParentFolderId(parentFolderIdElm.getText());
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_PARENT_FOLDER_ID) != null) {
            boxFolder.setParentFolderId(folderElm.attributeValue(BoxConstant.PARAM_NAME_PARENT_FOLDER_ID));
        }
        if (passwordElm != null) {
            boxFolder.setPassword(passwordElm.getText());
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_PASSWORD) != null) {
            boxFolder.setPassword(folderElm.attributeValue(BoxConstant.PARAM_NAME_PASSWORD));
        }
        if (pathElm != null) {
            boxFolder.setPath(pathElm.getText());
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_PATH) != null) {
            boxFolder.setPath(folderElm.attributeValue(BoxConstant.PARAM_NAME_PATH));
        }
        if (publicNameElm != null) {
            boxFolder.setPublicName(publicNameElm.getText());
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_PUBLIC_NAME) != null) {
            boxFolder.setPublicName(folderElm.attributeValue(BoxConstant.PARAM_NAME_PUBLIC_NAME));
        }
        if (sharedElm != null) {
            boxFolder.setShared(sharedElm.getText());
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_SHARED) != null) {
            boxFolder.setShared(folderElm.attributeValue(BoxConstant.PARAM_NAME_SHARED));
        }
        if (showCommentsElm != null) {
            boxFolder.setShowComments(showCommentsElm.getText());
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_SHOW_COMMENTS) != null) {
            boxFolder.setShowComments(folderElm.attributeValue(BoxConstant.PARAM_NAME_SHOW_COMMENTS));
        }
        if (userIdElm != null) {
            boxFolder.setUserId(userIdElm.getText());
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_USER_ID) != null) {
            boxFolder.setUserId(folderElm.attributeValue(BoxConstant.PARAM_NAME_USER_ID));
        }
        if (checksumElm != null) {
            boxFolder.setChecksum(checksumElm.getText());
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_CHECKSUM) != null) {
            boxFolder.setChecksum(folderElm.attributeValue(BoxConstant.PARAM_NAME_CHECKSUM));
        }
        if (hasCollaboratorsElm != null) {
            boxFolder.setHasCollaborators(hasCollaboratorsElm.getText());
        } else if (folderElm.attributeValue(BoxConstant.PARAM_NAME_HAS_COLLABORATORS) != null) {
            boxFolder.setHasCollaborators(folderElm.attributeValue(BoxConstant.PARAM_NAME_HAS_COLLABORATORS));
        }
        return boxFolder;
    }

    /**
     * @param infoElm
     *            info element
     * @return object
     */
    public static BoxFile toBoxFile(Element infoElm) {
        BoxFile boxFile = BoxObjectFactory.createBoxFile();

        Element fileIdElm = infoElm.element(BoxConstant.PARAM_NAME_FILE_ID);
        Element idElm = infoElm.element(BoxConstant.PARAM_NAME_ID);
        Element fileNameElm = infoElm.element(BoxConstant.PARAM_NAME_FILE_NAME);
        Element nameElm = infoElm.element(BoxConstant.PARAM_NAME_NAME);
        Element folderIdElm = infoElm.element(BoxConstant.PARAM_NAME_FOLDER_ID);
        Element sharedElm = infoElm.element(BoxConstant.PARAM_NAME_SHARED);
        Element sharedNameElm = infoElm.element(BoxConstant.PARAM_NAME_SHARED_NAME);
        Element sizeElm = infoElm.element(BoxConstant.PARAM_NAME_SIZE);
        Element descriptionElm = infoElm.element(BoxConstant.PARAM_NAME_DESCRIPTION);
        Element sha1Elm = infoElm.element(BoxConstant.PARAM_NAME_SHA1);
        Element createdElm = infoElm.element(BoxConstant.PARAM_NAME_CREATED);
        Element updatedElm = infoElm.element(BoxConstant.PARAM_NAME_UPDATED);
        Element createdByElm = infoElm.element(BoxConstant.PARAM_NAME_CREATED_BY);
        Element updatedByElm = infoElm.element(BoxConstant.PARAM_NAME_UPDATED_BY);
        if (fileIdElm != null) {
            boxFile.setFileId(fileIdElm.getText());
        } else if (idElm != null) {
            boxFile.setFileId(idElm.getText());
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_FILE_ID) != null) {
            boxFile.setFileId(infoElm.attributeValue(BoxConstant.PARAM_NAME_FILE_ID));
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_ID) != null) {
            boxFile.setFileId(infoElm.attributeValue(BoxConstant.PARAM_NAME_ID));
        }
        if (fileNameElm != null) {
            boxFile.setFileName(fileNameElm.getText());
        } else if (nameElm != null) {
            boxFile.setFileName(nameElm.getText());
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_FILE_NAME) != null) {
            boxFile.setFileName(infoElm.attributeValue(BoxConstant.PARAM_NAME_FILE_NAME));
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_NAME) != null) {
            boxFile.setFileName(infoElm.attributeValue(BoxConstant.PARAM_NAME_NAME));
        }
        if (folderIdElm != null) {
            boxFile.setFolderId(folderIdElm.getText());
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_NAME) != null) {
            boxFile.setFileName(infoElm.attributeValue(BoxConstant.PARAM_NAME_NAME));
        }
        String sharedStr = "";
        if (sharedElm != null) {
            sharedStr = sharedElm.getText();
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_SHARED) != null) {
            sharedStr = infoElm.attributeValue(BoxConstant.PARAM_NAME_SHARED);
        }
        if ("1".equals(sharedStr)) {
            boxFile.setShared(true);
        } else {
            boxFile.setShared(false);
        }

        if (sharedNameElm != null) {
            boxFile.setSharedName(sharedNameElm.getText());
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_NAME) != null) {
            boxFile.setFileName(infoElm.attributeValue(BoxConstant.PARAM_NAME_NAME));
        }

        long size = 0;
        String sizeStr = "0";
        if (sizeElm != null) {
            sizeStr = sizeElm.getText();
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_SIZE) != null) {
            sizeStr = infoElm.attributeValue(BoxConstant.PARAM_NAME_SIZE);
        }
        try {
            size = Long.parseLong(sizeStr);
        } catch (NumberFormatException e) {
            size = Long.MIN_VALUE;
        }
        boxFile.setSize(size);

        if (descriptionElm != null) {
            boxFile.setDescription(descriptionElm.getText());
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_DESCRIPTION) != null) {
            boxFile.setDescription(infoElm.attributeValue(BoxConstant.PARAM_NAME_DESCRIPTION));
        }
        if (sha1Elm != null) {
            boxFile.setSha1(sha1Elm.getText());
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_SHA1) != null) {
            boxFile.setSha1(infoElm.attributeValue(BoxConstant.PARAM_NAME_SHA1));
        }
        long created = 0;
        String createdStr = "0";
        if (createdElm != null) {
            createdStr = createdElm.getText();
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_CREATED) != null) {
            createdStr = infoElm.attributeValue(BoxConstant.PARAM_NAME_CREATED);
        }
        try {
            created = Long.parseLong(createdStr);
        } catch (NumberFormatException e) {
            created = Long.MIN_VALUE;
        }
        boxFile.setCreated(created);

        long updated = 0;
        String updatedStr = "0";
        if (updatedElm != null) {
            updatedStr = updatedElm.getText();
        }
        try {
            updated = Long.parseLong(updatedStr);
        } catch (NumberFormatException e) {
            updated = Long.MIN_VALUE;
        }
        boxFile.setUpdated(updated);

        if (createdByElm != null) {
            String createdBy = createdByElm.getText();
            boxFile.setCreatedBy(createdBy);
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_CREATED_BY) != null) {
            boxFile.setCreatedBy(infoElm.attributeValue(BoxConstant.PARAM_NAME_CREATED_BY));
        }

        if (updatedByElm != null) {
            String updatedBy = updatedByElm.getText();
            boxFile.setUpdatedBy(updatedBy);
        } else if (infoElm.attributeValue(BoxConstant.PARAM_NAME_UPDATED_BY) != null) {
            boxFile.setUpdatedBy(infoElm.attributeValue(BoxConstant.PARAM_NAME_UPDATED_BY));
        }

        return boxFile;
    }

    /**
     * @param friendsElm
     *            friends element
     * @return object list
     */
    public static List toFriendsList(Element friendsElm) {
        List friendsList = new ArrayList();
        if (friendsElm != null) {
            for (int i = 0; i < friendsElm.nodeCount(); i++) {
                BoxFriend friend = BoxObjectFactory.createBoxFriend();
                Element friendElm = (Element) friendsElm.node(i);

                Element nameElm = friendElm.element("name");
                Element emailElm = friendElm.element("email");
                Element acceptedElm = friendElm.element("accepted");
                Element avatarUrlElm = friendElm.element("avatar_url");
                Element boxesElm = friendElm.element("boxes");
                Element subscriptionsElm = friendElm.element("subscriptions");

                if (nameElm != null) {
                    friend.setName(nameElm.getText());
                }
                if (emailElm != null) {
                    friend.setEmail(emailElm.getText());
                }
                if (acceptedElm != null) {
                    friend.setAccepted(acceptedElm.getText());
                }
                if (avatarUrlElm != null) {
                    friend.setAvatarUrl(avatarUrlElm.getText());
                }
                List boxList = new ArrayList();
                if (boxesElm != null) {
                    for (int j = 0; j < boxesElm.nodeCount(); j++) {
                        Element boxElm = (Element) boxesElm.node(j);
                        Box box = toBox(boxElm);
                        boxList.add(box);
                    }
                }
                friend.setBoxes(boxList);

                List subscriptionList = new ArrayList();
                if (subscriptionsElm != null) {
                    for (int j = 0; j < subscriptionsElm.nodeCount(); j++) {
                        Element subscriptionElm = (Element) subscriptionsElm.node(j);
                        BoxSubscription subscription = toSubscription(subscriptionElm);
                        subscriptionList.add(subscription);
                    }
                }
                friend.setSubscriptions(subscriptionList);

                friendsList.add(friend);
            }
        }
        return friendsList;
    }

    /**
     * 
     * @param boxElm
     *            box element
     * @return object
     */
    public static Box toBox(Element boxElm) {
        Box box = BoxObjectFactory.createBox();
        Element idElm = boxElm.element("id");
        Element urlElm = boxElm.element("url");
        Element statusElm = boxElm.element("status");
        if (idElm != null) {
            box.setId(idElm.getText());
        }
        if (urlElm != null) {
            box.setUrl(urlElm.getText());
        }
        if (statusElm != null) {
            box.setStatus(statusElm.getText());
        }
        return box;
    }

    /**
     * 
     * @param subscriptionElm
     *            subscription element
     * @return object
     */
    public static BoxSubscription toSubscription(Element subscriptionElm) {
        BoxSubscription subscription = BoxObjectFactory.createBoxSubscription();
        Element boxIdElm = subscriptionElm.element("box_id");
        Element userNameElm = subscriptionElm.element("user_name");
        Element urlElm = subscriptionElm.element("url");
        Element statusElm = subscriptionElm.element("status");
        if (boxIdElm != null) {
            subscription.setBoxId(boxIdElm.getText());
        }
        if (userNameElm != null) {
            subscription.setUserName(userNameElm.getText());
        }
        if (urlElm != null) {
            subscription.setUrl(urlElm.getText());
        }
        if (statusElm != null) {
            subscription.setStatus(statusElm.getText());
        }
        return subscription;
    }

    /**
     * @param commentElm
     *            comment element
     * @return box comment
     */
    public static BoxComment toBoxComment(Element commentElm) {
        BoxComment boxComment = BoxObjectFactory.createBoxComment();
        Element commentIdElm = commentElm.element("comment_id");
        Element messageElm = commentElm.element("message");
        Element userIdElm = commentElm.element("user_id");
        Element userNameElm = commentElm.element("user_name");
        Element createdElm = commentElm.element("created");
        Element avatarUrlElm = commentElm.element("avatar_url");

        if (commentIdElm != null) {
            boxComment.setCommentId(commentIdElm.getText());
        }
        if (messageElm != null) {
            boxComment.setMessage(messageElm.getText());
        }
        if (userIdElm != null) {
            boxComment.setUserId(userIdElm.getText());
        }
        if (userNameElm != null) {
            boxComment.setUserName(userNameElm.getText());
        }
        if (createdElm != null) {
            long created = 0;
            try {
                created = Long.parseLong(createdElm.getText());
            } catch (NumberFormatException e) {
            }
            boxComment.setCreated(created);
        }
        if (avatarUrlElm != null) {
            boxComment.setAvatarUrl(avatarUrlElm.getText());
        }

        return boxComment;
    }

    /**
     * 
     * @param commentsElm
     *            comments element
     * @return list of comment object
     */
    public static List toBoxComments(Element commentsElm) {
        List comments = new ArrayList();
        if (commentsElm != null) {
            for (int i = 0; i < commentsElm.nodeCount(); i++) {
                Element commentElm = (Element) commentsElm.node(i);
                BoxComment boxComment = toBoxComment(commentElm);
                comments.add(boxComment);
            }
        }
        return comments;
    }

    /**
     * @param updatesElm
     *            updates element
     * @return list of update object
     */
    public static List toBoxUpdates(Element updatesElm) {
        List updates = new ArrayList();
        if (updatesElm != null) {
            for (int i = 0; i < updatesElm.nodeCount(); i++) {
                Element updateElm = (Element) updatesElm.node(i);
                BoxUpdate boxUpdate = toBoxUpdate(updateElm);
                updates.add(boxUpdate);
            }
        }
        return updates;
    }

    /**
     * @param updateElm
     *            update element
     * @return box update object
     */
    private static BoxUpdate toBoxUpdate(Element updateElm) {
        BoxUpdate boxUpdate = BoxObjectFactory.createBoxUpdate();
        Element updateIdElm = updateElm.element("update_id");
        if (updateIdElm != null) {
            boxUpdate.setUpdateId(updateIdElm.getText());
        }
        Element userIdElm = updateElm.element("user_id");
        if (userIdElm != null) {
            boxUpdate.setUserId(userIdElm.getText());
        }
        Element userNameElm = updateElm.element("user_name");
        if (userNameElm != null) {
            boxUpdate.setUserName(userNameElm.getText());
        }
        Element userEmailElm = updateElm.element("user_email");
        if (userEmailElm != null) {
            boxUpdate.setUserEmail(userEmailElm.getText());
        }
        Element updatedElm = updateElm.element("updated");
        if (updatedElm != null) {
            boxUpdate.setUpdated(updatedElm.getText());
        }
        Element updateTypeElm = updateElm.element("update_type");
        if (updateTypeElm != null) {
            boxUpdate.setUpdateType(updateTypeElm.getText());
        }
        Element folderIdElm = updateElm.element("folder_id");
        if (folderIdElm != null) {
            boxUpdate.setFolderId(folderIdElm.getText());
        }
        Element folderNameElm = updateElm.element("folder_name");
        if (folderNameElm != null) {
            boxUpdate.setFolderName(folderNameElm.getText());
        }
        Element sharedElm = updateElm.element("shared");
        if (sharedElm != null) {
            boxUpdate.setShared(sharedElm.getText());
        }
        Element sharedNameElm = updateElm.element("shared_name");
        if (sharedNameElm != null) {
            boxUpdate.setSharedName(sharedNameElm.getText());
        }
        Element ownerIdElm = updateElm.element("owner_id");
        if (ownerIdElm != null) {
            boxUpdate.setOwnerId(ownerIdElm.getText());
        }
        Element folderPathElm = updateElm.element("folder_path");
        if (folderPathElm != null) {
            boxUpdate.setFolderPath(folderPathElm.getText());
        }
        Element collabAccessElm = updateElm.element("collab_access");
        if (collabAccessElm != null) {
            boxUpdate.setCollabAccess(collabAccessElm.getText());
        }
        Element commentCountElm = updateElm.element("comment_count");
        if (commentCountElm != null) {
            boxUpdate.setCommentCount(commentCountElm.getText());
        }
        Element filesElm = updateElm.element("files");
        if (filesElm != null) {
            List fileList = new ArrayList();
            for (int i = 0; i < filesElm.nodeCount(); i++) {
                Element fileElm = (Element) filesElm.node(i);
                BoxFile boxFile = toBoxFile(fileElm);
                fileList.add(boxFile);
            }
            boxUpdate.setFiles(fileList);
        }
        Element foldersElm = updateElm.element("folders");
        if (foldersElm != null) {
            List folderList = new ArrayList();
            for (int i = 0; i < foldersElm.nodeCount(); i++) {
                Element folderElm = (Element) foldersElm.node(i);
                BoxFolder boxFolder = toBoxFolder(folderElm);
                folderList.add(boxFolder);
            }
            boxUpdate.setFolders(folderList);
        }
        Element discussionsElm = updateElm.element("discussions");
        if (discussionsElm != null) {
            List discussionList = new ArrayList();
            for (int i = 0; i < discussionsElm.nodeCount(); i++) {
                Element discussionElm = (Element) discussionsElm.node(i);
                // BoxDiscussion boxDiscussion = toBoxDiscussion(discussionElm);
                // discussionList.add(boxDiscussion);
            }
            boxUpdate.setDiscussions(discussionList);
        }
        return boxUpdate;
    }
}
