package com.salesmanager.core.modules.cms.content;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.salesmanager.core.business.content.model.image.ContentImage;
import com.salesmanager.core.business.content.model.image.ImageContentType;
import com.salesmanager.core.business.content.model.image.InputContentImage;
import com.salesmanager.core.business.content.model.image.OutputContentImage;
import com.salesmanager.core.business.generic.exception.ServiceException;
import com.salesmanager.core.business.merchant.model.MerchantStore;
import com.salesmanager.core.modules.cms.common.ImageRemove;
import com.salesmanager.core.modules.cms.product.CmsContentFileManagerInfinispanImpl;

public class ContentFileManagerImpl
    extends ContentFileManager
{

    private ImagePut uploadImage;

    private ContentImageGet getImage;

    private ImageRemove removeImage;

    private final static Logger LOG = LoggerFactory.getLogger( ContentFileManagerImpl.class );

    /**
     * Implementation for add image method. This method will called respected add image method of underlying
     * CMSContentManager. For CMS Content images {@link CmsContentFileManagerInfinispanImpl} will take care of adding
     * given content image with Infinispan cache.
     * 
     * @param store merchant store.
     * @param image Input content image
     * @throws ServiceException
     */
    @Override
    public void addImage( MerchantStore store, InputContentImage image )
        throws ServiceException
    {

        uploadImage.addImage( store, image );

    }

    @Override
    public List<OutputContentImage> getImages( MerchantStore store, ImageContentType imageContentType )
        throws ServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeImage( ContentImage contentImage )
        throws ServiceException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeImages( MerchantStore store )
        throws ServiceException
    {
        // TODO Auto-generated method stub

    }

    /**
     * Method to get images for a given merchant store.For fetching image all we need to provide MerchantStore for whole
     * image will be fetched and image name. It will return {@link OutputContentImage}
     * 
     * @param store merchantStore for whom image will be fetched
     * @param imageName name of the image
     * @param imageContentType {@link ImageContentType}
     * @throws ServiceException
     */
    @Override
    public OutputContentImage getImage( MerchantStore store, String imageName, ImageContentType imageContentType )
        throws ServiceException
    {
        return getImage.getImage( store, imageName, imageContentType );
    }

    public ImageRemove getRemoveImage()
    {
        return removeImage;
    }

    public void setRemoveImage( ImageRemove removeImage )
    {
        this.removeImage = removeImage;
    }

    public ContentImageGet getGetImage()
    {
        return getImage;
    }

    public void setGetImage( ContentImageGet getImage )
    {
        this.getImage = getImage;
    }

    public ImagePut getUploadImage()
    {
        return uploadImage;
    }

    public void setUploadImage( ImagePut uploadImage )
    {
        this.uploadImage = uploadImage;
    }

    @Override
    public List<String> getImageNames( MerchantStore store, ImageContentType imageContentType )
        throws ServiceException
    {
        // TODO Auto-generated method stub
        return null;
    }

}
