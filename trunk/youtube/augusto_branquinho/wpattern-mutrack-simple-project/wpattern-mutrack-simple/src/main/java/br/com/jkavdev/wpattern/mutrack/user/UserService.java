package br.com.jkavdev.wpattern.mutrack.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.wpattern.mutrack.utils.GenericService;
import br.com.jkavdev.wpattern.mutrack.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.USER_PATH)
public class UserService extends GenericService<UserEntity, Long>{

}
