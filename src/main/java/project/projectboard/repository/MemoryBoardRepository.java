package project.projectboard.repository;

import project.projectboard.domain.Board;

import java.util.*;

public class MemoryBoardRepository implements BoardRepository{

    private static Map<Long, Board> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Board save(Board board) {
        board.setId(++sequence);
        store.put(board.getId(), board);
        return board;
    }

    @Override
    public Optional<Board> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Board> findByTitle(String title) {
        return store.values().stream()
                .filter(board -> board.getTitle().equals(title))
                .findAny();
    }

    @Override
    public List<Board> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(Long id) {
    }
}
