package com.jme;

// Importações

import com.jme.*;
import com.jme3.*;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.FastMath;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.*;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.scene.shape.Sphere;
import com.jme3.util.SkyFactory;

public class Cenario {

  // Instancia objetos
  private Geometry grama;
  private Box quad;
  private Material matG;
  private Spatial ceu;
  

  // Cenario
  public Cenario(AssetManager assetManager, Node rootNode) {

    //Grama
  quad = new Box(700,0.1f,700);
  grama = new Geometry("Grama", quad);
  grama.setLocalTranslation(0, 0, 0);
  matG = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
  matG.setTexture("ColorMap", assetManager.loadTexture("Textures/grama.jpg"));
  grama.setMaterial(matG);

    // alvo
    
    
    
    
    
    //ceu
  ceu = SkyFactory.createSky(assetManager,"Textures/sky.jpeg", SkyFactory.EnvMapType.EquirectMap);
  rootNode.attachChild(ceu);
  rootNode.attachChild(grama);
  }
}
