

package com.example.demo.controller;

import com.example.demo.model.Regions;
import com.example.demo.service.ICategoriesService;
import com.example.demo.service.IRegionsService;
import com.example.demo.service.IRegionsService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api")
//@Transactional
@CrossOrigin("http://localhost:4200")
public class RegionsController {

    @Autowired
    private IRegionsService regionService;
   // @Autowired
   // private RegionsDao regionDao;
  //  private CategoriesDao categoriesDao;
   @Autowired
    private ICategoriesService categoriesService ;
    @GetMapping("/regions")
    public ResponseEntity<Collection<Regions>> getRegions() {
        Collection<Regions> Regions= (Collection<Regions>) regionService.findAll();
        return new ResponseEntity<Collection<Regions>>(Regions, HttpStatus.OK);
    }

    @GetMapping("/regions/{id}")
    public ResponseEntity<Optional<Regions>>getRegions(@PathVariable Long id) {
        Optional<Regions> region= regionService.findById(id);
        if(region==null){
           return new  ResponseEntity<Optional<Regions>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Regions>>(region,HttpStatus.OK);
    }

   @PostMapping("/regions")
    public ResponseEntity<Regions> createregion(@RequestBody Regions regionCreate, Principal principal) {
       KeycloakAuthenticationToken authenticationToken =(KeycloakAuthenticationToken) principal;
       AccessToken token =authenticationToken.getAccount().getKeycloakSecurityContext().getToken();
       String utilisateurConnect= token.getPreferredUsername();





       System.out.println("********************* 111111111 Debut *****************************");

       System.out.println("********************* 111111111 Debut *****************************");


       System.out.println("********************* Debut *****************************");
       //List<Categories> catListe  =categoriesDao.findAll();
       System.out.println(regionCreate);
       //Categories cat = new Categories();
     //  Optional<Categories>    cat = categoriesDao.findById(regionCreate.getImageId().getId());
      // Optional<Categories>    cat= regionCreate.getImageId().getId();

      //   long idIma =regionCreate.getImageId().getId();
       //System.out.println(regionCreate.getImageId().getId());
       System.out.println(regionCreate.getNomRegion());
      // region.setDescription(regionCreate.getDescription());
      // region.setLibelle(regionCreate.getLibelle());
     //  region.setQuantite(regionCreate.getQuantite());
       //

       //Categories cat = cd.get();
//       System.out.println(cat);
//       System.out.println(cat);
//       regionCreate.setImageId(cat);

      // regionCreate.setImageId("fffff");
//       System.out.println(utilisateurConnect);
//       System.out.println(Connectutilisateur);
//       System.out.println(utiliConnect);

      //1 regionCreate.setUtilisateur("amote");
      //1 Regions Regionset = new Regions();
       //1Regionset.setUtilisateur("Amote");+" "+Connectutilisateur+" "+ utiliConnect

      // regionCreate.setUtilisateur(utilisateurConnect);
       regionCreate.setDateCreation(new Date());
      // region.setCategorie(this.categoriesService.findById(Long new 22);
      // regionCreate.setCategorie(categoriesService.findOne(regionCreate.getCategorie()));
      // regionCreate.setCategorie(cat);
      // Regions saveregion= regionService.create(regionCreate);
      Regions saveregion= regionService.create(regionCreate);
       //saveregion.setUtilisateur
       //return new ResponseEntity<Regions>( HttpStatus.CREATED);
        return new ResponseEntity<Regions>(saveregion, HttpStatus.CREATED);
    }

    @PutMapping("/regions")
    public ResponseEntity<Regions> updateregion(@RequestBody Regions regionCreate, Principal principal) {
      //  DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "aaaa/MM/jj HH:mm:ss" );
       // LocalDateTime now = LocalDateTime.now();
       // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       // Date date = new Date();


        KeycloakAuthenticationToken authenticationToken =(KeycloakAuthenticationToken) principal;
        AccessToken token =authenticationToken.getAccount().getKeycloakSecurityContext().getToken();
        String utilisateurConnect= token.getPreferredUsername();

        System.out.println(utilisateurConnect);
       // regionCreate.setUtilisateur(utilisateurConnect);
        regionCreate.setDateCreation(new Date());
        Regions saveregion = regionService.update(regionCreate);


            return new ResponseEntity<Regions>(saveregion, HttpStatus.OK);
    }
    @DeleteMapping("/regions/{id}")
    public ResponseEntity<Regions> deleteregion(@PathVariable Long id) {
        regionService.delete(id);

        return new ResponseEntity<>( HttpStatus.OK);
    }
}


