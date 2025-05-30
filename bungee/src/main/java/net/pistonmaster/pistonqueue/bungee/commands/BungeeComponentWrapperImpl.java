/*
 * #%L
 * PistonQueue
 * %%
 * Copyright (C) 2021 AlexProgrammerDE
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package net.pistonmaster.pistonqueue.bungee.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.pistonmaster.pistonqueue.shared.chat.ComponentWrapper;
import net.pistonmaster.pistonqueue.shared.chat.TextColorWrapper;
import net.pistonmaster.pistonqueue.shared.chat.TextDecorationWrapper;

public record BungeeComponentWrapperImpl(ComponentBuilder mainComponent) implements ComponentWrapper {
    @Override
    public ComponentWrapper append(String text) {
        return new BungeeComponentWrapperImpl(mainComponent.append(text));
    }

    @Override
    public ComponentWrapper append(ComponentWrapper component) {
        return new BungeeComponentWrapperImpl(mainComponent.append(((BungeeComponentWrapperImpl) component).mainComponent().create()));
    }

    @Override
    public ComponentWrapper color(TextColorWrapper color) {
        return new BungeeComponentWrapperImpl(mainComponent.color(switch (color) {
            case GOLD -> ChatColor.GOLD;
            case RED -> ChatColor.RED;
            case DARK_BLUE -> ChatColor.DARK_BLUE;
            case GREEN -> ChatColor.GREEN;
        }));
    }

    @Override
    public ComponentWrapper decorate(TextDecorationWrapper decoration) {
        return new BungeeComponentWrapperImpl(switch (decoration) {
            case BOLD -> mainComponent.bold(true);
        });
    }
}
