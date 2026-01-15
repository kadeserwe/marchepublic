

package com.example.demo.controller;

import com.example.demo.model.Produits;
import com.example.demo.model.Stocks;
import com.example.demo.service.ICategoriesService;
import com.example.demo.service.IStocksService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@Transactional
@CrossOrigin("http://localhost:4200")
public class StocksController {

    @Autowired
    private IStocksService stockService;

//   @Autowired
//    private ICategoriesService categoriesService ;
//
    @GetMapping("/stocks")
    public ResponseEntity<Collection<Stocks>> getStock() {
        Collection<Stocks> stock= (Collection<Stocks>) stockService.findAll();


        return new ResponseEntity<Collection<Stocks>>(stock, HttpStatus.OK);
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Optional<Stocks>>getStock(@PathVariable Long id) {
        Optional<Stocks> stock= stockService.findById(id);
        if(stock==null){
           return new  ResponseEntity<Optional<Stocks>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Stocks>>(stock,HttpStatus.OK);
    }



   @PostMapping("/stocks")
    public ResponseEntity<Stocks> createStock(@RequestBody Stocks stockCreate, Principal principal) {
        try{
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
       System.out.println(stockCreate);
       //Categories cat = new Categories();
       //  Optional<Categories>    cat = categoriesDao.findById(produitCreate.getImageId().getId());
       // Optional<Categories>    cat= produitCreate.getImageId().getId();

       //   long idIma =produitCreate.getImageId().getId();
       //System.out.println(produitCreate.getImageId().getId());
       System.out.println(stockCreate.getDescription());
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

       stockCreate.setUtilisateur(utilisateurConnect);
       stockCreate.setDateCreation(new Date());

       // produit.setCategorie(this.categoriesService.findById(Long new 22);
       // produitCreate.setCategorie(categoriesService.findOne(produitCreate.getCategorie()));
       // produitCreate.setCategorie(cat);
       // Produits saveProduit= produitService.create(produitCreate);
       Stocks saveStocks= stockService.create(stockCreate);
       //saveProduit.setUtilisateur
       //return new ResponseEntity<Produits>( HttpStatus.CREATED);
       return new ResponseEntity<Stocks>(saveStocks, HttpStatus.CREATED);

        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", exc);
        }
    }

    @PutMapping("/stocks")
    public ResponseEntity<Stocks> updateStock(@RequestBody Stocks stockCreate, Principal principal) {
        System.out.println("******************************");
        System.out.println(stockCreate);
        KeycloakAuthenticationToken authenticationToken =(KeycloakAuthenticationToken) principal;
        AccessToken token =authenticationToken.getAccount().getKeycloakSecurityContext().getToken();
        String utilisateurConnect= token.getPreferredUsername();
        stockCreate.setUtilisateur(utilisateurConnect);


        stockCreate.setDateCreation(new Date());
        Stocks saveStock = stockService.update(stockCreate);



        return new ResponseEntity<Stocks>(saveStock, HttpStatus.OK);
    }
    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<Stocks> deleteProduit(@PathVariable Long id) {

        try {
            stockService.delete(id);

            return new ResponseEntity<>( HttpStatus.OK);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible d'executer", exc);
        }
    }

}


