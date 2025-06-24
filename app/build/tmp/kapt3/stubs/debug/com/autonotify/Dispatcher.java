package com.autonotify;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/autonotify/Dispatcher;", "", "()V", "sendMessage", "", "context", "Landroid/content/Context;", "contactNumber", "", "message", "platform", "sendSMS", "number", "sendViaTelegram", "sendViaWhatsApp", "app_debug"})
public final class Dispatcher {
    @org.jetbrains.annotations.NotNull()
    public static final com.autonotify.Dispatcher INSTANCE = null;
    
    private Dispatcher() {
        super();
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String contactNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String platform) {
    }
    
    private final void sendSMS(android.content.Context context, java.lang.String number, java.lang.String message) {
    }
    
    private final void sendViaWhatsApp(android.content.Context context, java.lang.String number, java.lang.String message) {
    }
    
    private final void sendViaTelegram(android.content.Context context, java.lang.String message) {
    }
}