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
  private Quad alvo1;
  private Material matAlvo;
  private Geometry alvoPlano;
  private Geometry alvoPlano2;
  private Geometry  alvoPlano3;
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
    alvo1 = new Quad(75,75);
    alvoPlano = new Geometry("Alvo", alvo1);
    matAlvo = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    matAlvo.setTexture("ColorMap", assetManager.loadTexture("Textures/alvotxt.jpg"));
    alvoPlano.setMaterial(matAlvo);
    
    
    alvoPlano2 =  alvoPlano.clone();
    alvoPlano3 =  alvoPlano.clone();
    
    alvoPlano.setLocalTranslation(-100f, 15, -50);
    alvoPlano2.setLocalTranslation(0f, 15, -75);
    alvoPlano3.setLocalTranslation(100f, 15, -50);
    
    
    //ceu
  ceu = SkyFactory.createSky(assetManager,"Textures/sky.jpeg", SkyFactory.EnvMapType.EquirectMap);
  rootNode.attachChild(ceu);
  rootNode.attachChild(alvoPlano);
  rootNode.attachChild(alvoPlano2);
  rootNode.attachChild(alvoPlano3);
  rootNode.attachChild(grama);
  }
}
