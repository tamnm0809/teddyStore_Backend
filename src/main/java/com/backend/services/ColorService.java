package com.backend.services;

import java.util.List;

import com.backend.model.Color;

public interface ColorService {

	Object getAllColor(int page, int size);

	Object updateColor(String id, String color);

	Object searchColor(String color);

	Object getAllColor();
}
