package org.example.controller;

import org.example.service.KeyService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@Component
@Scope(value = "singleton")
public class KeyController extends KeyAdapter {
    private final KeyService service;

    public KeyController(KeyService service) {
        this.service = service;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keycode = e.getKeyCode();

        service.handleKeyEvent(keycode);
    }
}
