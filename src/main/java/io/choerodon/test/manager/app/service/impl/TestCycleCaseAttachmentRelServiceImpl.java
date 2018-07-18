package io.choerodon.test.manager.app.service.impl;

import io.choerodon.core.convertor.ConvertHelper;
import io.choerodon.test.manager.api.dto.TestCycleCaseAttachmentRelDTO;
import io.choerodon.test.manager.app.service.TestCycleCaseAttachmentRelService;
import io.choerodon.test.manager.domain.test.manager.entity.TestCycleCaseAttachmentRelE;
import io.choerodon.test.manager.domain.service.ITestCycleCaseAttachmentRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 842767365@qq.com on 6/11/18.
 */
@Component
public class TestCycleCaseAttachmentRelServiceImpl implements TestCycleCaseAttachmentRelService {

    @Autowired
    ITestCycleCaseAttachmentRelService iTestCycleCaseAttachmentRelService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(String bucketName, Long attachId) {
        iTestCycleCaseAttachmentRelService.delete(bucketName, attachId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public TestCycleCaseAttachmentRelDTO upload(String bucketName, String fileName, MultipartFile file, Long attachmentLinkId, String attachmentType, String comment) {
        return ConvertHelper.convert(iTestCycleCaseAttachmentRelService.upload(bucketName, fileName, file, attachmentLinkId, attachmentType, comment), TestCycleCaseAttachmentRelDTO.class);
    }

}
