package hello.itemservice.domain.item;

import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>();
    // 동시에 접근 하면 쓰면 안됨. ConcurrentHashMap을 쓸것
    private  static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long id, Item updateParam) {
        Item findItem = findById(id);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
        // 중복이냐 명학성이냐 하면 명확성을 따르는게 항상 좋다.
    }

    public void clearStore() {
        store.clear();
    }
}
