package org.paules.geckoboard.api.json.serializer;

import java.awt.Color;
import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * @author Paul van Assen
 */
public class AwtColorTypeAdapter extends TypeAdapter<Color> {

    @Override
    public void write( JsonWriter out, Color color ) throws IOException {
        String colorStr = String.format( "%06X%02X", ( 0xFFFFFF & color.getRGB() ), ( 0xFF & color.getAlpha() ) );
        out.value( colorStr );
    }

    @Override
    public Color read( JsonReader in ) throws IOException {
        // We only do writing atm
        return null;
    }

}