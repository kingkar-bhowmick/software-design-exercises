package shop.notification;

public record Message(String to, String subject, String body, byte[] attachment) {
}
