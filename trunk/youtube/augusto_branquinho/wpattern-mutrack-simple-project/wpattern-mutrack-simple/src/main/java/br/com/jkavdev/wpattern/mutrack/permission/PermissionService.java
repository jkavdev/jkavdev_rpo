package br.com.jkavdev.wpattern.mutrack.permission;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.wpattern.mutrack.utils.GenericService;
import br.com.jkavdev.wpattern.mutrack.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.PERMISSION_PATH)
public class PermissionService extends GenericService<PermissionEntity, Long> {

}
