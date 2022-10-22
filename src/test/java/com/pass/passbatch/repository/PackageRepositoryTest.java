package com.pass.passbatch.repository;

import com.pass.passbatch.repository.packaze.PackageEntity;
import org.junit.Test;
import org.mockito.internal.matchers.NotNull;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertNotNull;

@SpringBatchTest
@ActiveProfiles("test")
public class PackageRepositoryTest {

    @Autowired
    private PackageRepositoryTest packageRepositoryTest;

    @Test
    public void test_save() {
        // given
        PackageEntity packageEntity = new PackageEntity();
        packageEntity.setPackageName("바디 챌린지 PT 12주");
        packageEntity.setPeriod(84);

        // when

        // then
        assertNotNull(packageEntity.getPackageSeq());
    }
}
