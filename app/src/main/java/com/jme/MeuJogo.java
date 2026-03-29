package com.jme;

import android.widget.Toast;
import com.jme3.app.*;
import com.jme3.asset.AssetManager;
import com.jme3.material.*;
import com.jme3.math.*;
import com.jme3.scene.*;
import com.jme3.scene.shape.*;
import com.jme3.texture.*;
import com.jme3.*;
import com.jme3.util.SkyFactory;
import com.jme.Cenario;


public class MeuJogo extends SimpleApplication {
    Cenario cenario;
    @Override
    public void simpleInitApp() {
  
    cenario = new Cenario(assetManager, rootNode);
    cam.setLocation(new Vector3f(0,70,50));
    cam.lookAt(new Vector3f(6,6,6), Vector3f.UNIT_Y);
        
    }
    
    @Override
    public void simpleUpdate(float tpf) {
        // Lógica do jogo aqui
        
        
        
    }
}