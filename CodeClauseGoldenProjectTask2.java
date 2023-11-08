import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaGenerator {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 50;
    private static final int FONT_SIZE = 30;
    private static final int CAPTCHA_LENGTH = 6;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    
    public static BufferedImage generateCaptcha() {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        
        Random random = new Random();
        
        // Set background color
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        
        // Generate random captcha string
        StringBuilder captchaText = new StringBuilder();
        for (int i = 0; i < CAPTCHA_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            captchaText.append(randomChar);
        }
        
        // Draw captcha text
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        graphics.drawString(captchaText.toString(), 20, HEIGHT / 2 + FONT_SIZE / 2);
        
        // Add noise to the image
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                int randomGray = random.nextInt(256);
                image.setRGB(i, j, new Color(randomGray, randomGray, randomGray).getRGB());
            }
        }
        
        return image;
    }
    
    public static void main(String[] args) {
        BufferedImage captchaImage = generateCaptcha();
        // Save the captcha image to a file or display it in a GUI
    }
}