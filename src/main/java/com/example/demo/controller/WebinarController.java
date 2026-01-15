package com.example.demo.controller;
import com.example.demo.dao.IwebinarDao;
import com.example.demo.model.WebinarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WebinarController {
    @Autowired
    private IwebinarDao webinarDao;

    //Récupérer tous les webinars
    @GetMapping("/webinar")
    public List<WebinarModel> listeWebinars(){

        return webinarDao.findAll();
    }

 /*   //Récupérer un webinar par son Id
    @GetMapping("/escale/{libelle}")
    public WebinarModel recupererWebinarLibelle(@PathVariable String libelle) {
        return webinarDao.findByLibelle(libelle);
    }
*/

    //Récupérer un webinar par son Id
    @GetMapping("/webinar/{id}")
    public WebinarModel recupererWebinarId(@PathVariable int id) {
        return webinarDao.findById(id);
    }
    //ajouter un Webinar
    @PostMapping("/webinar")
    public void ajouterWebinar(@RequestBody WebinarModel webinarModel) {
        webinarDao.save(webinarModel);
    }

    /*modifier un Webinar*/
    @PutMapping(value = "/webinar")
    public void modifierWebinare(@RequestBody WebinarModel webinarModel) {
        webinarDao.save(webinarModel);
    }

    /* supprimer un webinar*/
    @DeleteMapping(value="/webinar/{id}")
    public void supprimerWebinar(@PathVariable int id) {
        if(id!=0){
            try {
                WebinarModel webinarModel = webinarDao.findById(id);
                //webinarModel.setIsDeleted(1);
                webinarDao.delete(webinarModel);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}