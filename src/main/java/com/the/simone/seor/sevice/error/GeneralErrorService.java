package com.the.simone.seor.sevice.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.the.simone.seor.model.error.AnagraficaExc;
import com.the.simone.seor.model.error.BaseError;
import com.the.simone.seor.model.error.PostExc;
import com.the.simone.seor.model.error.SicurezzaExc;
import com.the.simone.seor.model.error.UtenteExc;


@RestControllerAdvice
public class GeneralErrorService {
	
	// utente error handler
	@ExceptionHandler(UtenteExc.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseError handleNoRecordFoundException(UtenteExc ex) 
	{

		BaseError response = new BaseError();
		response.setErrDescr(" utente non trovato nel db");
		response.setErrId("AUK_01");
		response.setErrType("db_error");
		response.setError(true);
	    
	    return response;
	}
	// post error handler
	@ExceptionHandler(PostExc.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseError handleNoRecordFoundException(PostExc ex) 
	{

		BaseError response = new BaseError();
		response.setErrDescr(" post non trovato nel db");
		response.setErrId("AUK_02");
		response.setErrType("db_error");
		response.setError(true);
	    
	    return response;
	}
	@ExceptionHandler(SicurezzaExc.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseError handleNoRecordFoundException(SicurezzaExc ex) 
	{

		BaseError response = new BaseError();
		response.setErrDescr(" errore durante la registrazione utente");
		response.setErrId("AUK_03");
		response.setErrType("db_error_ut_&_sic");
		response.setError(true);
	    
	    return response;
	}
	@ExceptionHandler(AnagraficaExc.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseError handleNoRecordFoundException(AnagraficaExc ex) 
	{

		BaseError response = new BaseError();
		response.setErrDescr(" errore durante la ricerca anagrafica dell'eutente");
		response.setErrId("AUK_04");
		response.setErrType("db_error_ut_&_anag");
		response.setError(true);
	    
	    return response;
	}
	

}
