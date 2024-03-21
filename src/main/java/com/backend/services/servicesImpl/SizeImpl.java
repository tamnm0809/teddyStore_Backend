package com.backend.services.servicesImpl;

import java.util.List;
import java.util.Random;

import com.backend.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.backend.model.Size;
import com.backend.repository.SizeRepository;
import com.backend.services.SizeService;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class SizeImpl implements SizeService {
    private final SizeRepository sizeRepository;

    @Override
    public Object getAllSize(int page, int size) {
        var pageable = PageRequest.of(page, size);
        return sizeRepository.findAll(pageable);
    }

    @Override
    public Object updateSize(String id, String size_no) {
		// Nếu id tồn tại thì update, không tồn tại thì tạo mới
        var size = sizeRepository.findById(id);

		// kiểm tra xem size có tồn tại không
        if (size.isPresent()) {
			// update thong tin size
            var size1 = size.get();
            size1.setSize_no(size_no);
            sizeRepository.save(size1);
        } else {
			// tim size cuoi cung de tao id moi theo quy tac tu tang tu dong
            var lastSize = sizeRepository.findLastSize();
            var newSize = new Size();
			// truong hop da co size cuoi cung, thi tao id tang tu dong
            if (lastSize.isPresent()) {
                newSize.setId(RandomUtil.getNextId(lastSize.get().getId(), "SI"));
            } else {
				// truong hop chua co size nao, tao id moi voi SI00000001
                newSize.setId(RandomUtil.getNextId(null, "SI"));
            }
            newSize.setSize_no(size_no);
            sizeRepository.save(newSize);
        }
        return "OK";
    }

    @Override
    public Object searchSize(String sizeNo) {
		// tim kiem size theo size_no
        return sizeRepository.findAllByName(sizeNo, PageRequest.of(0, 10));
    }

    @Override
    public Object getAllSize() {
        return sizeRepository.findAll();
    }

}
