package trol.domain.filemanager;

import trol.domain.trol_api.model.WordsList;
import trol.domain.util.FileHelper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PhrasesList {
    private Path path;
    private WordsList wordsList;

    public PhrasesList(WordsList wordsList) {
        path = Paths.get(FilePaths.PHRASE_LISTS_PATH +wordsList.getWordsListName());
        this.wordsList = wordsList;
    }

    public PhrasesList(Path path, WordsList wordsList) {
        this.path = path;
        this.wordsList = wordsList;
    }

    public void saveFile() throws IOException {
        List<String> phrasesFile = new ArrayList<>();
        wordsList.getWordsSet().forEach(e -> phrasesFile.add(wordLine(e.getWordString())));
        FileHelper.saveStringListAsFile(path,phrasesFile);
    }

    private String wordLine(String word){
        return "<"+word+">";
    }
}
