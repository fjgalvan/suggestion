package configuration;

import provider.IProvider;

public interface IConfiguration {
	public IProvider configureProvider(IPanel panel);
}
