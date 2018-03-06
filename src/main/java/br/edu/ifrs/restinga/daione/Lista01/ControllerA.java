package br.edu.ifrs.restinga.daione.Lista01;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerA {
    
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/h2")
    @ResponseBody
    String home2() {
        return "Hello World!2";
    }
    
    /*
    Questão 01
    */
    
    @RequestMapping("/imc/{peso}/{altura:.+}")
    @ResponseBody
    public String imc( 
                       @PathVariable double peso,
                       @PathVariable double altura){
        
        DecimalFormat df = new DecimalFormat("#0.00");
        
        
        
        double imc =  peso/(altura*altura); 
            
        if(imc <= 18.5) return "Seu imc é "+ df.format(imc)+" vocé tá virado num palito";
        else if(imc >18.5 && imc <= 24.9) return "Seu imc normal é de " + df.format(imc);
        else if(imc >25 && imc <= 29.9) return "Seu imc apresenta sobrepeso e é de " + df.format(imc);
        else if(imc >30 && imc <= 34.9) return "Seu imc  é de obesidade grau um " + df.format(imc);
        else if(imc >35 && imc <= 39.9) return "Seu imc é de " + df.format(imc) + ": obesidade grau dois";
        else if(imc > 40) return "Seu imc é de " + df.format(imc) +": nível insano de obesidade ou obesidade grau três";
        
               
        return "Seu IMC é " + imc;
    }

    /*
    Questão 02
    */
    
    @RequestMapping("/semana/{dia}/{mes}/{ano}")
    @ResponseBody
    public String diaSemana(
                     @PathVariable int dia, 
                     @PathVariable int mes, 
                     @PathVariable int ano
    ) throws ParseException{
        
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        Date d = s.parse("" + dia + "/"+ mes+ "/" +ano);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(d);
        int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
        
        String diaS = null;
        
        switch (diaDaSemana){
            case 1: diaS = "DOMINGO"; break; 
            case 2: diaS = "SEGUNDA"; break;
            case 3: diaS = "TERÇA"; break;
            case 4: diaS = "QUARTA"; break;
            case 5: diaS = "QUINTA"; break;
            case 6: diaS = "SEXTA"; break;
            case 7: diaS = "SABADO"; 
                break;
                
        }
        
        return "O DIA DA SEMANA É " + diaS;
    }
    
/*
    Questão 3
    */
    @RequestMapping("/calculadora/{operacao}/{numero01}/{numero02}")
    @ResponseBody
    public String calculadora(
                                @PathVariable String operacao,
                                @PathVariable double numero01, 
                                @PathVariable double numero02
            
                                ){
        String retorno = null;
        
        switch(operacao){
            case "adicao": retorno = "O resultado da adicao é "+ (numero01+numero02); break; 
            case "multiplicacao": retorno = "O resultado da multiplicacao é "+ (numero01*numero02); break; 
            case "subtracao": retorno = "O resultado da subtracao é "+ (numero01 - numero02); break; 
            case "divisao": retorno = "O resultado da divisao é "+ (numero01/numero02); break; 
            
        }
        
        return retorno; 
    }
    
    
    @RequestMapping("/calculadora02/{operacao}")
    @ResponseBody
    public String calculadora02(
                                    @PathVariable String operacao, 
                                    @RequestParam("n1") String n1,
                                     @RequestParam("n2") String n2){
   
         String retorno = null;
         double num01 = Double.parseDouble(n1); 
         double num02 = Double.parseDouble(n2); 
         double resultado =0.0; 
    switch(operacao){
            case "adicao": resultado = num01+num02; retorno = "O resultado da adicao é "+ resultado; break; 
            case "multiplicacao": resultado = num01*num02; retorno = "O resultado da multiplicacao é "+ resultado; break; 
            case "subtracao": resultado = num01-num02; retorno = "O resultado da subtracao é "+ resultado; break; 
            case "divisao": resultado = num01/num02; retorno = "O resultado da divisao é "+ resultado; break; 
            
        }
            
        
        
        return retorno;
    }
}
