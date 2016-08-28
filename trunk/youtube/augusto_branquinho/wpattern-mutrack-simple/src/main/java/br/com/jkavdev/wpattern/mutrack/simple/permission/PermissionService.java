package br.com.jkavdev.wpattern.mutrack.simple.permission;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.wpattern.mutrack.simple.utils.GenericService;
import br.com.jkavdev.wpattern.mutrack.simple.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.PERMISSION_PATH)
public class PermissionService extends GenericService<PermissionEntity, Long> {

}
