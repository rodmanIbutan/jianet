package com.zyh.jianet.contorller;

import com.zyh.jianet.entity.Space;
import com.zyh.jianet.entity.Status;
import com.zyh.jianet.service.SpaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("space")
public class SpaceController {
    final SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }
    @GetMapping("/getSpace")
    @ResponseBody
    public Status<List<Space>> getSpace(@RequestHeader("token") String token){
        return spaceService.getSpace(token);
    }

    @GetMapping("/getSpaceById")
    @ResponseBody
    public Status<Space> getSpaceById(@RequestParam("id") Integer id){
        return spaceService.getSpaceById(id);
    }
}
