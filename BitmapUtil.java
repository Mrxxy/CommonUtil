public class BitmapUtil { 
    /**
    * @param filePath  Ҫ���ص�ͼƬ·��
    * @param destWidth  ��ʾͼƬ�Ŀؼ����
    * @param destHeight ��ʾͼƬ�Ŀؼ��ĸ߶�
    * @return
    */ 
    public static Bitmap resizeBitmap(String filePath, int destWidth, int destHeight) { 
        //��һ�β��� 
        BitmapFactory.Options options = new BitmapFactory.Options(); 
        //����������Ϊtrueֻ�����ͼƬ�ı߿���������������ͼƬ��������ص� 
        options.inJustDecodeBounds = true; 
        //��һ�μ���ͼƬ����ʱֻ�����ͼƬ�ı߿���������������ͼƬ�е����ص� 
        BitmapFactory.decodeFile(filePath, options); 
        //���ԭͼ�Ŀ�͸� 
        int outWidth = options.outWidth; 
        int outHeight = options.outHeight; 
        //�������ű��� 
        int sampleSize = 1; 
        while (outHeight / sampleSize > destHeight || outWidth / sampleSize > destWidth) { 
            //�����ߵ�����һ�������ű���û�дﵽҪ�󣬶������������ű��� 
            //sampleSizeӦ��Ϊ2��n���ݣ������sampleSize���õ����ֲ���2��n���ݣ���ôϵͳ��ͽ�ȡֵ 
            sampleSize *= 2; 
        } 
        /********************************************************************************************/ 
        //���ˣ���һ�β����Ѿ������������Ѿ��ɹ��ļ������sampleSize�Ĵ�С 
        /********************************************************************************************/ 
        //���β�����ʼ 
        //���β���ʱ����Ҫ��ͼƬ���س�����ʾ������ֻ����ͼƬ�Ŀ�ܣ����inJustDecodeBounds����Ҫ����Ϊfalse 
        options.inJustDecodeBounds = false; 
        //�������ű��� 
        options.inSampleSize = sampleSize; 
        options.inPreferredConfig = Bitmap.Config.ARGB_8888; 
        //����ͼƬ������ 
        return BitmapFactory.decodeFile(filePath, options); 
    } 
}


//��ȡ�ӽ����޵����ű�
private float resize(String path, Bitmap mViewBitmap, float mCurrentScale, int mMaxResultImageSizeX, int mMaxResultImageSizeY) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        boolean swapSides = mExifInfo.getExifDegrees() == 90 || mExifInfo.getExifDegrees() == 270;
        float scaleX = (swapSides ? options.outHeight : options.outWidth) / (float) mViewBitmap.getWidth();
        float scaleY = (swapSides ? options.outWidth : options.outHeight) / (float) mViewBitmap.getHeight();

        float resizeScale = Math.min(scaleX, scaleY);

        mCurrentScale /= resizeScale;

        resizeScale = 1;
        if (mMaxResultImageSizeX > 0 && mMaxResultImageSizeY > 0) {
            float cropWidth = mCropRect.width() / mCurrentScale;
            float cropHeight = mCropRect.height() / mCurrentScale;

            if (cropWidth > mMaxResultImageSizeX || cropHeight > mMaxResultImageSizeY) {

                scaleX = mMaxResultImageSizeX / cropWidth;
                scaleY = mMaxResultImageSizeY / cropHeight;
                resizeScale = Math.min(scaleX, scaleY);

                mCurrentScale /= resizeScale;
            }
        }
        return resizeScale;
    }