package sistema.beans;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.primefaces.event.RowEditEvent;

import com.sun.org.glassfish.gmbal.ManagedOperation;

import sistema.service.Service;

public class ManagedBean<T> {
	protected Service<T> service;
	protected T model;
	protected List<T> models;

	protected ManagedBean(Service<T> service) {
		this.service = service;
		instanceModel();
	}
	
	@SuppressWarnings("unchecked")
	protected void instanceModel() {
		try {
			model = (T) ((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
					.getActualTypeArguments()[0]).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@ManagedOperation
	public void save() {
		service.save(model);
		instanceModel();
		models = null;
	}

	@SuppressWarnings("unchecked")
	@ManagedOperation
	public void onRowEdit(RowEditEvent event) {
		update((T) event.getObject());
	}

	public void update(T model) {
		service.update(model);
		models = null;
	}

	@ManagedOperation
	public void delete(T model) {
		service.delete(model);
		models = null;
	}

	protected List<T> getList() {
		models = models == null ? service.getList() : models;
		return models;
	}
}
