

package com.example.demo.controller;

import com.example.demo.dao.ProduitsDao;
import com.example.demo.model.Commandes;
import com.example.demo.service.ICommandesService;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
//@Transactional
@CrossOrigin("http://localhost:4200")

public class CommandesController {

    @Autowired
    private ICommandesService commandeService;

    @Autowired
    private ProduitsDao produitRepository;

    //@RolesAllowed("user")

    @GetMapping("/commandes")

    public ResponseEntity<Collection<Commandes>> getCommandes() {
        Collection<Commandes> commandes= (Collection<Commandes>) commandeService.findAll();
        String mama="MC";
        //this.vie();
        System.out.println("++++++++++++++++++++ffffffff+++++++++");
        return new ResponseEntity<Collection<Commandes>>(commandes, HttpStatus.OK);
    }

    @GetMapping("/commandes/{id}")
    public ResponseEntity<Optional<Commandes>>getCommande(@PathVariable Long id) {
        String mama="MC";
       // this.vie();
        Optional<Commandes> commande= commandeService.findById(id);
        if(commande==null){
           return new  ResponseEntity<Optional<Commandes>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<Optional<Commandes>>(commande,HttpStatus.OK);
    }


    @PostMapping("/commandes")
    public ResponseEntity<Commandes> createCommande(@RequestBody Commandes commandeCreate, Principal principal) {
        try{
       KeycloakAuthenticationToken authenticationToken =(KeycloakAuthenticationToken) principal;
       AccessToken token =authenticationToken.getAccount().getKeycloakSecurityContext().getToken();
       String utilisateurConnect= token.getPreferredUsername();



       commandeCreate.setUtilisateur(utilisateurConnect);
      //      Produits pd = produitRepository.getOne(new Long(31));
      // commandeCreate.setProduit(pd);
           Double prixU=commandeCreate.getProduit().getPrixUnitaire();
            Long quantite=commandeCreate.getquantiteCommande();

            Long total=quantite*Double.valueOf(prixU).longValue();
            commandeCreate.setTotal(total);

       Commandes saveCommandes= commandeService.create(commandeCreate);

       return new ResponseEntity<Commandes>(saveCommandes, HttpStatus.CREATED);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", exc);
        }
    }

    @PutMapping("/commandes")
    public ResponseEntity<Commandes> updateClient(@RequestBody Commandes commandeUpdte,  Principal principal) {
        KeycloakAuthenticationToken authenticationToken =(KeycloakAuthenticationToken) principal;
        AccessToken token =authenticationToken.getAccount().getKeycloakSecurityContext().getToken();
        String utilisateurConnect= token.getPreferredUsername();
       // Produits pd = produitRepository.getOne(new Long(31));
      //  commandeUpdte.setProduit(pd);


        Double prixU=commandeUpdte.getProduit().getPrixUnitaire();
        Long quantite=commandeUpdte.getquantiteCommande();

        Long total=quantite*Double.valueOf(prixU).longValue();
        commandeUpdte.setTotal(total);
        Commandes saveCommande = commandeService.update(commandeUpdte);


            return new ResponseEntity<Commandes>(saveCommande, HttpStatus.OK);
    }
    @DeleteMapping("/commandes/{id}")
    public ResponseEntity<Commandes> deleteCommandes(@PathVariable Long id) {


        try {
            commandeService.delete(id);

            return new ResponseEntity<>( HttpStatus.OK);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible d'executer", exc);
        }
    }


    @GetMapping("/commandeclient/{client}")
    public ResponseEntity<List<Commandes>> findByClientId(@PathVariable Long client) {
        try {
            List<Commandes> commandeByClient= commandeService.findByClientId(client);
            if(commandeByClient==null){

                return new  ResponseEntity<List<Commandes>>(HttpStatus.NOT_FOUND);

            }


            return new ResponseEntity<List<Commandes> >(commandeByClient,HttpStatus.OK);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", exc);
        }
    }
    public void  vie(int n,List<String> factureList,   int sum  ){
        System.out.println("--------dd--------"+n);
        System.out.println(factureList);
        System.out.println(sum);
    }

    @GetMapping("/getfacture/{idclient}")
    public ResponseEntity<List<Commandes>> getFacture(@PathVariable Long idclient){
        Document document = new Document(PageSize.A4);
        List<String> factureList = new ArrayList<>();
        List<Integer> totauxList = new ArrayList<Integer>();
        Integer totaux;
        int sum = 0;
        try {
            List<Commandes> commandeByClient= commandeService.findByClientId(idclient);
            if(commandeByClient==null){

              return    new ResponseEntity<List<Commandes> >(commandeByClient,HttpStatus.NOT_FOUND)  ;

            }

            commandeByClient.forEach(c ->{
                System.out.println("-----forEach---------------");
                // libelleP    =  c.getProduit().getLibelle();
                factureList.add(c.getquantiteCommande().toString());
                factureList.add(c.getProduit().getLibelle());
                factureList.add(c.getNumeroCommande());
                factureList.add(c.getProduit().getPrixUnitaire().toString());
                factureList.add(c.getTotal().toString());
                totauxList.add(c.getTotal().intValue());
                // System.out.println(libelleP);

                System.out.println(factureList);
                System.out.println("-----forEach1---------------");
            });



            for (int i = 0; i < totauxList.size(); i++)
                sum += totauxList.get(i);

            System.out.println("sum-> " + sum);

            int nbre = commandeByClient.size();
            //System.out.println("-----nbre-- totauxList-------------"+nbre);
            System.out.println("-----nbre-- totauxList-------------"+totauxList);
          //  this.vie(nbre, factureList, sum);


        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream("/Users/HP/Desktop/bjdoc/factz.pdf"));

            document.open();

            document.addTitle("Facture");
            Paragraph paraFact=new Paragraph("Facture" );
            paraFact.setAlignment(Element.ALIGN_CENTER);
            document.add(paraFact);
            String nom = "Amote Kades";
            com.lowagie.text.List liste = new com.lowagie.text.List(20);
            liste.setListSymbol(new Chunk("B",
                    FontFactory.getFont(FontFactory.ZAPFDINGBATS, 20, Font.BOLD, Color.BLUE)));
            liste.add(new ListItem(nom));
            liste.add(new ListItem("tel : 775632145"));
            liste.add(new ListItem(""));
            document.add(liste);
           int nbreLigne= 2;


            Table tableau = new Table(5, nbre);
            tableau.setAutoFillEmptyCells(true);
            tableau.setPadding(2);

            Cell cellq = new Cell("quantité");
            cellq.setBackgroundColor(Color.BLUE);
            cellq.setHeader(true);
            cellq.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableau.addCell(cellq);


            Cell celll = new Cell("libelle");
            celll.setBackgroundColor(Color.BLUE);
            celll.setHeader(true);
            celll.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableau.addCell(celll);

            Cell cell = new Cell("reference");
            cell.setBackgroundColor(Color.BLUE);
            cell.setHeader(true);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableau.addCell(cell);

            cell = new Cell("prix");
            cell.setBackgroundColor(Color.BLUE);
            cell.setHeader(true);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableau.addCell(cell);

            Cell	cellt = new Cell("total");
            cellt.setBackgroundColor(Color.BLUE);
            cellt.setHeader(true);
            cellt.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableau.addCell(cellt);

            tableau.endHeaders();

                 for (String detailFac : factureList) {
                     Cell  cells = new Cell(detailFac);
                    cells.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tableau.addCell(cells);


            }
            document.add(tableau);

            Paragraph paraTotal=new Paragraph("     totaux:     "+sum );
            paraTotal.setAlignment(Element.ALIGN_CENTER);
            document.add(paraTotal);
        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        document.close();


            factureList.clear();
            totauxList.clear();
            return new ResponseEntity<List<Commandes> >(commandeByClient,HttpStatus.OK);
    }catch (Exception exc) {
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Foo Not Found", exc);
    }

    }}



