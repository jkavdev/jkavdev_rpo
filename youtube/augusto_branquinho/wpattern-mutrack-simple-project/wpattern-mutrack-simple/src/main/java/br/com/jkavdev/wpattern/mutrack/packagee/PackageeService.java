package br.com.jkavdev.wpattern.mutrack.packagee;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.wpattern.mutrack.utils.GenericService;
import br.com.jkavdev.wpattern.mutrack.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.PACKAGEE_PATH)
public class PackageeService extends GenericService<PackageeEntity, Long> {
	
	@Override
	public PackageeEntity insert(@RequestBody PackageeEntity entity) {
		
		//nova data
		entity.setRegisterDate(new Date());
		
		return super.insert(entity);
	}

}
