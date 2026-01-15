

package com.example.demo.controller;

import com.example.demo.dao.CategoriesDao;
import com.example.demo.dao.ProduitsDao;
import com.example.demo.model.Categories;
import com.example.demo.model.Clients;
import com.example.demo.model.Communes;
import com.example.demo.model.Produits;
import com.example.demo.service.ICategoriesService;
import com.example.demo.service.IClientsService;
import com.example.demo.service.IProduitsService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@Transactional
@CrossOrigin("http://localhost:4200")
public class ProduitsController {

    @Autowired
    private IProduitsService produitService;
   // @Autowired
   // private ProduitsDao produitDao;
  //  private CategoriesDao categoriesDao;
   @Autowired
    private ICategoriesService categoriesService ;
    @GetMapping("/produits")
    public ResponseEntity<Collection<Produits>> getProduits() {
        Collection<Produits> produits= (Collection<Produits>) produitService.findAll();
        return new ResponseEntity<Collection<Produits>>(produits, HttpStatus.OK);
    }

    @GetMapping("/produits/{id}")
    public ResponseEntity<Optional<Produits>>getProduits(@PathVariable Long id) {
        try {
        Optional<Produits> produit= produitService.findById(id);
        if(produit==null){
           return new  ResponseEntity<Optional<Produits>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Produits>>(produit,HttpStatus.OK);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", exc);
        }
    }



    @GetMapping("/produitsfour/{fournisseur}")
    public ResponseEntity<List<Produits>> findByFournisseurtId(@PathVariable Long fournisseur) {
        try {
        List<Produits> produitFournissuerId= produitService.findByFournisseurId(fournisseur);
        if(produitFournissuerId==null){
            return new  ResponseEntity<List<Produits>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<List<Produits> >(produitFournissuerId,HttpStatus.OK);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", exc);
        }
    }

   @PostMapping("/produits")
    public ResponseEntity<Produits> createProduit(@RequestBody Produits produitCreate, Principal principal) {
   try {
       KeycloakAuthenticationToken authenticationToken =(KeycloakAuthenticationToken) principal;
       AccessToken token =authenticationToken.getAccount().getKeycloakSecurityContext().getToken();
       String utilisateurConnect= token.getPreferredUsername();
//       String Connectutilisateur= token.getEmail();
//       String utiliConnect= token.getName();
      // Collection<Categories>  ct= categoriesDao.findAll();




       System.out.println("********************* 111111111 Debut *****************************");

       System.out.println("********************* 111111111 Debut *****************************");


      // Categories monCat = new Categories ();
      // monCat.setId(new Long(22));
//       clt.forEach(c ->{
//
//
//           if(c.getId().equals(produitCreate.getImageId())){
//               System.out.println("iffffffffff");
//               Optional<Categories> catId = categoriesDao.findById(new Long(c.getId()));
//               System.out.println(catId);
//
//
//
//
//
//           }else{
//               System.out.println("errrrr");
//           }
//       });
       //

      // System.out.println(cd);
       System.out.println("********************* Debut *****************************");
       //List<Categories> catListe  =categoriesDao.findAll();
       System.out.println(produitCreate);
       //Categories cat = new Categories();
     //  Optional<Categories>    cat = categoriesDao.findById(produitCreate.getImageId().getId());
      // Optional<Categories>    cat= produitCreate.getImageId().getId();

      //   long idIma =produitCreate.getImageId().getId();
       //System.out.println(produitCreate.getImageId().getId());
       System.out.println(produitCreate.getDescription());
      // produit.setDescription(produitCreate.getDescription());
      // produit.setLibelle(produitCreate.getLibelle());
     //  produit.setQuantite(produitCreate.getQuantite());
       //

       //Categories cat = cd.get();
//       System.out.println(cat);
//       System.out.println(cat);
//       produitCreate.setImageId(cat);

      // produitCreate.setImageId("fffff");
//       System.out.println(utilisateurConnect);
//       System.out.println(Connectutilisateur);
//       System.out.println(utiliConnect);

      //1 produitCreate.setUtilisateur("amote");
      //1 Produits produitset = new Produits();
       //1produitset.setUtilisateur("Amote");+" "+Connectutilisateur+" "+ utiliConnect

       produitCreate.setUtilisateur(utilisateurConnect);
       produitCreate.setDateCreation(new Date());
      // produit.setCategorie(this.categoriesService.findById(Long new 22);
      // produitCreate.setCategorie(categoriesService.findOne(produitCreate.getCategorie()));
      // produitCreate.setCategorie(cat);
      // Produits saveProduit= produitService.create(produitCreate);
      Produits saveProduit= produitService.create(produitCreate);
       //saveProduit.setUtilisateur
       //return new ResponseEntity<Produits>( HttpStatus.CREATED);
        return new ResponseEntity<Produits>(saveProduit, HttpStatus.CREATED);
            }
      catch (Exception exc) {
       throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Foo Not Found", exc);
            }
    }

    @PutMapping("/produits")
    public ResponseEntity<Produits> updateProduit(@RequestBody Produits produitCreate, Principal principal) {

        KeycloakAuthenticationToken authenticationToken =(KeycloakAuthenticationToken) principal;
        AccessToken token =authenticationToken.getAccount().getKeycloakSecurityContext().getToken();
        String utilisateurConnect= token.getPreferredUsername();
        produitCreate.setUtilisateur(utilisateurConnect);
        produitCreate.setDateCreation(new Date());
        Produits saveProduit = produitService.update(produitCreate);


            return new ResponseEntity<Produits>(saveProduit, HttpStatus.OK);
    }
    @DeleteMapping("/produits/{id}")
    public ResponseEntity<Produits> deleteProduit(@PathVariable Long id) {
     try {
        produitService.delete(id);

        return new ResponseEntity<>( HttpStatus.OK);
                }
          catch (Exception exc) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible d'executer", exc);
                }
    }

}


