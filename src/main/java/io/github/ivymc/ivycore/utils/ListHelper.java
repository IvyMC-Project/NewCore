package io.github.ivymc.ivycore.utils;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@SuppressWarnings("unused")
public class ListHelper {
    private static final Random random = new Random();
    public static <T> Optional<T> getRandomOrEmpty(List<T> list) {
        return list.isEmpty() ? Optional.empty() : Optional.of(getRandom(list));
    }

    public static <T> T getRandom(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }
}
