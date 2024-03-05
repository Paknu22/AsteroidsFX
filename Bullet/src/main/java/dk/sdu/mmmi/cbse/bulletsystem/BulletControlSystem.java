package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService, BulletSPI {

    @Override
    public void process(GameData gameData, World world) {
        float speed = 5f;
        for (Entity bullet : world.getEntities(Bullet.class)) {
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX * speed);
            bullet.setY(bullet.getY() + changeY * speed);
        }
    }

    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {
        Entity activeBullet = new Bullet();
        activeBullet.setPolygonCoordinates(1,1,-1,1,-0.5,-0.5,0.5,-0.5);
        activeBullet.setX(shooter.getX());
        activeBullet.setY(shooter.getY());
        activeBullet.setRotation(shooter.getRotation());
        return activeBullet;

    }
}
