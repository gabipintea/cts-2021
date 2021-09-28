package gabriel.pintea.g1094.composite;

import gabriel.pintea.g1094.singleton.ServerInterface;

public abstract class AbstractNode implements ServerInterface {
	public abstract void addNewNode(AbstractNode node);
	public abstract void deleteNode(AbstractNode node);
	public abstract AbstractNode getNode(int index);

}
