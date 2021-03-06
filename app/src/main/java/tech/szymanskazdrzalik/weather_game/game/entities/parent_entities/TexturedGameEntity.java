package tech.szymanskazdrzalik.weather_game.game.entities.parent_entities;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import tech.szymanskazdrzalik.weather_game.game.entities.parent_entities.GameEntity;

public class TexturedGameEntity extends GameEntity {
    private Bitmap texture;

    public Bitmap getTexture() {
        return texture;
    }

    public void setTexture(Bitmap texture) {
        this.texture = texture;
    }

    public int getHitboxHeight() {
        return this.texture.getHeight();
    }

    public int getHitboxWidth() {
        return this.texture.getWidth();
    }

    public double getHitboxStartX() {
        return this.getXPos();
    }

    public double getHitboxStartY() {
        return this.getYPos();
    }

    public TexturedGameEntity(Point location, int textureWidth, int textureHeight, Bitmap bitmap) {
        super(location);
        this.texture = Bitmap.createScaledBitmap(bitmap, textureWidth, textureHeight, false);
    }

    public TexturedGameEntity(int xPos, int yPos, int textureWidth, int textureHeight, Bitmap bitmap) {
        this(new Point(xPos, yPos), textureWidth, textureHeight, bitmap);
    }

    public TexturedGameEntity(Point location, int textureWidth, int textureHeight, Resources resources, int id) {
        super(location);
        this.texture = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, id), textureWidth, textureHeight, false);
    }

    public TexturedGameEntity(int xPos, int yPos, int textureWidth, int textureHeight, Resources resources, int id) {
        this(new Point(xPos, yPos), textureWidth, textureHeight, resources, id);
    }
}
