package header;

import java.util.Objects;

public class Header {
    public static void show(String loggedInName) {
        String loggedInMessage = Objects.requireNonNullElse(loggedInName, " ");

        System.out.printf("""
                ╔═════════════════════════════════════════════════════════════════╗
                ║                                                    ║
                ║      _       _                        _                         ║
                ║     /_\\   __| | __ _  /\\/\\  _   _ ___(_) ___                    ║
                ║    //_\\\\ / _` |/ _` |/    \\| | | / __| |/ __|                   ║
                ║   /  _  \\ (_| | (_| / /\\/\\ \\ |_| \\__ \\ | (__                    ║
                ║   \\_/ \\_/\\__,_|\\__,_\\/    \\/\\__,_|___/_|\\___|                   ║
                ║                                                    ║
                ╚═════════════════════════════════════════════════════════════════╝
                """, loggedInMessage);
    }
}