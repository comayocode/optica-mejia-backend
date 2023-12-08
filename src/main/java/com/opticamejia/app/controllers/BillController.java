package com.opticamejia.app.controllers;

import com.opticamejia.app.models.BillModel;
import com.opticamejia.app.models.PatientModel;
import com.opticamejia.app.services.BillService;
import com.opticamejia.app.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;

    @Autowired
    PatientService patientService;

    @GetMapping()
    public ArrayList<BillModel> getBills() {
        return billService.getBills();
    }

    @PostMapping()
    public BillModel saveBill(@RequestBody BillModel bill) {

        Date date = new Date();
        bill.setDate(date);

        PatientModel patient = patientService.getById(4).get();
        bill.setPatient(patient);

        return this.billService.saveBill(bill);
    }

    @GetMapping(path = "/{id}")
    public Optional<BillModel> getById(@PathVariable("id") Integer id) {
        return this.billService.getById(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<BillModel> getByCode(@RequestParam("code") String code) {
        return this.billService.getByCode(code);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        boolean ok = this.billService.deleteBill(id);
        if (ok) {
            return "Factura eliminada";
        } else {
            return "Error al eliminar la factura";
        }
    }

}
