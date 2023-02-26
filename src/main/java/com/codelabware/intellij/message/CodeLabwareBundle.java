package com.codelabware.intellij.message;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.util.function.Supplier;

/**
 * @author <a href="https://github.com/LiLittleCat">LiLittleCat</a>
 * @since 0.0.1
 */
public class CodeLabwareBundle extends DynamicBundle {
    @NonNls
    private static final String BUNDLE = "messages.CodeLabwareBundle";
    private static final CodeLabwareBundle INSTANCE = new CodeLabwareBundle();

    private CodeLabwareBundle() {
        super(BUNDLE);
    }

    @NotNull
    public static @Nls String message(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, Object @NotNull ... params) {
        return INSTANCE.getMessage(key, params);
    }

    @NotNull
    public static Supplier<@Nls String> messagePointer(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, Object @NotNull ... params) {
        return INSTANCE.getLazyMessage(key, params);
    }
}
