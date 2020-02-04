package github.akanemiku.akaneblog.service.impl;

import github.akanemiku.akaneblog.model.Option;
import github.akanemiku.akaneblog.repository.OptionRepository;
import github.akanemiku.akaneblog.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionRepository optionRepository;

    @Override
    public List<Option> getOptions() {
        return optionRepository.findAll();
    }

    @Override
    public void saveOptions(Map<String, String> options) {
        if (null != options && !options.isEmpty()) {
            Option option = new Option();
            options.forEach((k,v)->{
                option.setName(k);
                option.setValue(v);
                optionRepository.save(option);
            });
        }
    }
}