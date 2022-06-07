package org.wso2.carbon.apimgt.certifications.trainoperations;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping(value="/v1", produces = {MediaType.APPLICATION_XML_VALUE})
public class ScheduleRestControllerV1 {
	ScheduleManager manager = ScheduleManager.getManager();

	@RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.HEAD })
	public void handleHead() {
	}

	@GetMapping({ "/schedules" })
	public List<ScheduleEntry> getSchedules() {
		return this.manager.getAllSchedules();
	}

	@PostMapping({ "/schedules" })
	public ScheduleEntry addSchedule(@RequestBody ScheduleEntry entry) {
		return this.manager.addScheduleEntry(entry);
	}

	@GetMapping({ "/schedules/{id}" })
	public ScheduleEntry getSchedule(@PathVariable String id) {
		return this.manager.getSchedule(id);
	}

	@PutMapping({ "/schedules/{id}" })
	public void updateSchedule(@RequestBody ScheduleEntry entry, @PathVariable String id) {
		this.manager.updateScheduleEntry(entry, id);
	}

	@DeleteMapping({ "/schedules/{id}" })
	public void deleteSchedule(@PathVariable String id) {
		this.manager.deleteScheduleEntry(id);
	}
}
