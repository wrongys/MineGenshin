package minegenshin.wrong.init;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeyBindingInit {

    public static final KeyBinding SKILL = new KeyBinding("key.minegenshin.skill",
            KeyConflictContext.IN_GAME,
            KeyModifier.NONE,
            Keyboard.KEY_C,
            "key.minegenshin"
    );

    public static final KeyBinding BURST = new KeyBinding("key.minegenshin.burst",
            KeyConflictContext.IN_GAME,
            KeyModifier.NONE,
            Keyboard.KEY_R,
            "key.minegenshin"
    );

    public static final KeyBinding[] KEY_BINDINGS = {
            SKILL,
            BURST
    };

    public static void init() {

        for (KeyBinding keyBinding : KEY_BINDINGS
        ) {
            ClientRegistry.registerKeyBinding(keyBinding);

        }
    }
}
