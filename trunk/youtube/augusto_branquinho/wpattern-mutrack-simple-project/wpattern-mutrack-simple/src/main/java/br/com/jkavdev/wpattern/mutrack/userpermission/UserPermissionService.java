package br.com.jkavdev.wpattern.mutrack.userpermission;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.wpattern.mutrack.utils.GenericService;
import br.com.jkavdev.wpattern.mutrack.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.USER_PERMISSION_PATH)
public class UserPermissionService extends GenericService<UserPermissionEntity, UserPermissionKey> {

}
