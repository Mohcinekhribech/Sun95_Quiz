package com.youcode.sunquizz.domains.Media;

import com.youcode.sunquizz.domains.Media.DTOs.MediaReqDTO;
import com.youcode.sunquizz.domains.Media.DTOs.MediaRespDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MediaServiceInterface {
    MediaRespDTO getMedia(Integer id);
    Page<MediaRespDTO> getMedias(Pageable pageable);
    List<MediaRespDTO> getMediaByType(MediaType type);
    MediaRespDTO createMedia(MediaReqDTO media);
    MediaRespDTO updateMedia(MediaReqDTO media,Integer id);
    Integer deleteMedia(Integer id);
}
