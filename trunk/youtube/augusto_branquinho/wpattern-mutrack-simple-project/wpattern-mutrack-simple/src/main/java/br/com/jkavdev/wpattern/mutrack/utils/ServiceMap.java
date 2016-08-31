package br.com.jkavdev.wpattern.mutrack.utils;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

//todos os tipos de requisicoes terao acesso aos servicos
@CrossOrigin(origins = "*")
@RequestMapping(consumes = "application/json", produces = "application/json")
public interface ServiceMap {

}
