package org.example;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Main {
    public static void main(String[] args) {
        try {
            // Load the QR code image
            File qrCodeFile = new File("path/to/qr/code");
            BufferedImage bufferedImage = ImageIO.read(qrCodeFile);

            // Convert the image to a binary bitmap
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            // Use the MultiFormatReader to decode the QR code
            MultiFormatReader reader = new MultiFormatReader();
            Result result = reader.decode(bitmap);
            
            // Print the result
            System.out.println("QR Code Content: " + result.getText());
        } catch (NotFoundException e) {
            System.err.println("QR Code not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
