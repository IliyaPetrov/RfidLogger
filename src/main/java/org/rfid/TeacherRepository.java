package org.rfid;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by iliyapetrov on 24.07.16.
 */
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {
    Teacher findByRfid(@Param("name") String rfid);
}
