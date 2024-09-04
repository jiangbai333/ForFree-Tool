package idni.jbc.forfree.tool.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import java.io.*;

public class Compress {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        System.out.println(args[0]);
        System.out.println(args[1]);

        File input = new File("/Users/jiangbaichao/Desktop/head.png");
        BufferedImage image = ImageIO.read(input);
        image = removeAlphaChannel(image);

        File compressedImageFile = new File("/Users/jiangbaichao/Desktop/head_compressed.jpg");
        OutputStream os = new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.15f);  // Change the quality value you prefer
        writer.write(null, new IIOImage(image, null, null), param);

        os.close();
        ios.close();
        writer.dispose();
    }
    private static BufferedImage removeAlphaChannel(BufferedImage img) {
        if (!img.getColorModel().hasAlpha()) {
            return img;
        }

        BufferedImage target = createImage(img.getWidth(), img.getHeight(), false);
        Graphics2D g = target.createGraphics();
        // g.setColor(new Color(color, false));
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        g.drawImage(img, 0, 0, null);
        g.dispose();

        return target;
    }
    private static BufferedImage createImage(int width, int height, boolean hasAlpha) {
        return new BufferedImage(width, height, hasAlpha ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);
    }
}
