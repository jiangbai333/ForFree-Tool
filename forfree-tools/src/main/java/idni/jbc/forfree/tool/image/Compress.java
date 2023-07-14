package idni.jbc.forfree.tool.image;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public class Compress {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.out.println(args[0]);
        System.out.println(args[1]);

        File input = new File("/Users/jiangbaichao/Desktop/img_48e967d7079331abcce319ca8661be00.png");
        BufferedImage image = ImageIO.read(input);

        File compressedImageFile = new File("/Users/jiangbaichao/Desktop/compressed_image.jpg");
        OutputStream os = new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.05f);  // Change the quality value you prefer
        writer.write(null, new IIOImage(image, null, null), param);

        os.close();
        ios.close();
        writer.dispose();
    }
}
